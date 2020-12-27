package com.hamidreza.mvisample.repository

import com.hamidreza.mvisample.data.local.LocalMapper
import com.hamidreza.mvisample.data.local.UserDao
import com.hamidreza.mvisample.data.model.User
import com.hamidreza.mvisample.data.remote.RemoteMapper
import com.hamidreza.mvisample.data.remote.UserApi
import com.hamidreza.mvisample.utils.ResultState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val dao: UserDao, private val api: UserApi,
    private val remoteMapper: RemoteMapper,
    private val localMapper: LocalMapper
) {

     fun getUsers(): Flow<ResultState<List<User>>> = flow {
        emit(ResultState.Loading)
        delay(1000)
        try {
            val response = api.getUsers()
            if (response.isSuccessful) {
                response.body()?.let {
                    val remoteUsers = remoteMapper.mapFromEntityList(it)
                    for (user in remoteUsers) {
                        dao.insert(localMapper.mapToEntity(user))
                    }
                    val users = localMapper.mapFromEntityList(dao.getUsers())
                    emit(ResultState.Success(users))
                }
            } else {
                emit(ResultState.Error("در برقرای ارتباط با سرور مشکلی وجود دارد"))
            }
        } catch (e:IOException) {
            emit(ResultState.Error("وضعیت اینترنت خود را چک کنید"))
        }

    }

}