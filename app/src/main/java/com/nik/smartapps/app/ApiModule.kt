package com.nik.smartapps.app

import com.nik.smartapps.data.ResponseSharedPreference
import com.nik.smartapps.data.web.ServerApi
import com.nik.smartapps.data.web.ServerRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://random-data-api.com/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun provideApi(retrofit: Retrofit): ServerApi = retrofit.create(ServerApi::class.java)

    @Provides
    fun provideRepo(api: ServerApi, serverPreference : ResponseSharedPreference) = ServerRepository(serverPreference,api)
}