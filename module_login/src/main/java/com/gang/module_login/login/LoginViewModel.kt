package com.gang.module_login.login

import androidx.lifecycle.MutableLiveData
import com.gang.module_login.LoginRepository
import com.gang.lib_base.LogUtils
import com.gang.module_base.BaseViewModel
import java.lang.Exception

class LoginViewModel : BaseViewModel() {
    private val repository = lazy { LoginRepository() }

    val name = MutableLiveData<String>()
    val pwd = MutableLiveData<String>()
    val isMobile = MutableLiveData<Boolean>()

    val hint = MutableLiveData<String>()

    init {
        name.postValue("")
        pwd.postValue("")
        isMobile.postValue(false)
    }

    fun setMobile() {
        isMobile.postValue(!(isMobile.value!!))
    }

    fun login() {
        go {
            LogUtils.print("=1=${Thread.currentThread().name}")
            LogUtils.print("=2=${Thread.currentThread().name}")
            try {
                val data = repository.value.login(name.value!!, pwd.value!!)
            } catch (e: Exception) {
                hint.postValue(e.message.toString())
            }
        }
    }

}