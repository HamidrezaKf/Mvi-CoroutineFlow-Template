package com.hamidreza.mvisample.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserLocalEntity::class],version = 1)
abstract class UserDataBase : RoomDatabase(){

    abstract fun getUserDao() : UserDao

}