package com.gang.lib_base

import retrofit2.http.GET

interface ApiService {
    @GET("https://www.apiopen.top/novelApi")
    suspend fun getFictions(): String
}