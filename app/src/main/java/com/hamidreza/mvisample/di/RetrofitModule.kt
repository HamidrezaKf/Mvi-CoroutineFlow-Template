package com.hamidreza.mvisample.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.hamidreza.mvisample.data.remote.UserApi
import com.hamidreza.mvisample.utils.Conts.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RetrofitModule {

    fun provideGson() : Gson = GsonBuilder().create()


    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson) : Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    @Singleton
    @Provides
    fun provideUserApi(retrofit: Retrofit) : UserApi =
        retrofit.create(UserApi::class.java)
}