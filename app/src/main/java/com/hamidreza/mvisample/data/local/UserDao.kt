package com.hamidreza.mvisample.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(userLocalEntity: UserLocalEntity)

    fun getUsers() : List<UserLocalEntity>
}