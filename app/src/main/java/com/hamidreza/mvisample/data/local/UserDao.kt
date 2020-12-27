package com.hamidreza.mvisample.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(userLocalEntity: UserLocalEntity)

    @Query("SELECT * FROM users")
    suspend fun getUsers() : List<UserLocalEntity>
}