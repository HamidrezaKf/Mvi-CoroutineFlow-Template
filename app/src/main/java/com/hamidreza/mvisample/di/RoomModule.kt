package com.hamidreza.mvisample.di

import android.content.Context
import androidx.room.Room
import com.hamidreza.mvisample.data.local.UserDao
import com.hamidreza.mvisample.data.local.UserDataBase
import com.hamidreza.mvisample.utils.Conts.DB_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RoomModule {

    @Singleton
    @Provides
    fun provideUserDb(@ApplicationContext context: Context): UserDataBase =
        Room.databaseBuilder(
            context,
            UserDataBase::class.java,
            DB_NAME
        ).fallbackToDestructiveMigration()
            .build()

    @Singleton
    @Provides
    fun provideDao(db:UserDataBase): UserDao = db.getUserDao()
}