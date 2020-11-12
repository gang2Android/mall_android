package com.gang.lib_base

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit
import javax.net.ssl.*

class HttpManager private constructor(baseUrl: String) {
    private var mRetrofit: Retrofit? = null

    init {
        getRetrofitClient(baseUrl)
    }

    companion object {
        @Volatile
        var instance: HttpManager? = null
        fun getInstance(baseUrl: String): HttpManager {
            if (instance == null) {
                synchronized(HttpManager::class) {
                    if (instance == null) {
                        instance = HttpManager(baseUrl)
                    }
                }
            }
            return instance!!
        }
    }

    private fun getOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .hostnameVerifier(HostnameVerifier { hostname, session -> true })
            .build()
    }

    private fun getRetrofitClient(baseUrl: String): Retrofit {
        if (mRetrofit == null) {
            mRetrofit = Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .client(getOkHttpClient())
                .build()
        }
        return mRetrofit!!
    }

    fun <T> getService(service: Class<T>): T? {
        return mRetrofit!!.create(service)
    }

}