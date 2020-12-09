package com.dyl.module_login

import com.gang.lib_base.HttpManager
import com.gang.lib_base.LogUtils
import com.gang.module_base.BaseRepository
import java.lang.Exception

class LoginRepository : BaseRepository() {
    private var apiService = lazy {
        HttpManager.getInstance("http://xxx/")
            .getService(LoginService::class.java)
    }

    suspend fun login(name: String, pwd: String): UserBean {
        if (name == "") {
            throw Exception("请输入手机号")
        }
        if (pwd == "") {
            throw Exception("请输入密码")
        }

        val data = apiService.value!!.getUserLogin(name, pwd)
        LogUtils.print(data.isSuccess().toString())
        if (data.isSuccess()) {
            return data.data
        }
        throw Exception(data.msg)
    }

    suspend fun getCode(mobile: String) {
        Thread.sleep(2000)
    }


}