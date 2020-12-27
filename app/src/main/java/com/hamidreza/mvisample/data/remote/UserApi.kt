package com.hamidreza.mvisample.data.remote

import com.hamidreza.mvisample.data.remote.UserRemoteModel.UserRemoteEntity
import retrofit2.Response
import retrofit2.http.GET


interface UserApi {

    @GET("users")
    suspend fun getUsers() : Response<List<UserRemoteEntity>>

}