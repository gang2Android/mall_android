package com.dyl.module_login

class UserBean(var mem_token: String, var token: String)

class BaseBean<T>(var status: String, var msg: String, var data: T) {
    fun isSuccess() = status == "1"
}