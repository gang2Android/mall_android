package com.gang.module_user.reg

import androidx.lifecycle.MutableLiveData
import com.gang.module_base.BaseViewModel
import com.gang.module_user.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RegViewModel : BaseViewModel() {
    private val repository = lazy { UserRepository() }

    val name = MutableLiveData<String>()
    val mobile = MutableLiveData<String>()
    val code = MutableLiveData<String>()
    val pwd = MutableLiveData<String>()
    val pwd1 = MutableLiveData<String>()
    val inviteCode = MutableLiveData<String>()
    val getCodeStr = MutableLiveData<String>()

    init {
        name.postValue("")
        mobile.postValue("")
        code.postValue("")
        pwd.postValue("")
        pwd1.postValue("")
        inviteCode.postValue("")
        getCodeStr.postValue("获取验证码")
    }

    var count = 60

    fun getCode() {
        if (count != 60) {
            return
        }
        go {
            withContext(Dispatchers.Default) {
                repository.value.getCode()
                while (count != 0) {
                    getCodeStr.postValue("${count}S后重新获取")
                    Thread.sleep(1000)
                    count -= 1
                }
                getCodeStr.postValue("重新获取验证码")
                count = 60
            }
        }
    }

    fun reg() {
    }


}