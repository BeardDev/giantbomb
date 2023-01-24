package com.nik.smartapps.data.web

import com.nik.smartapps.data.entity.Server
import retrofit2.http.GET

interface ServerApi {
    @GET("users")
    suspend fun getApi() : Server
}