package com.gang.module_login

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LoginService {

    @FormUrlEncoded
    @POST("service-sso/shiro/user/login/check")
    suspend fun getUserLogin(
        @Field("username") name: String,
        @Field("password") pwd: String
    ): BaseBean<UserBean>

}