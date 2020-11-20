package com.gang.module_user.pwd

import androidx.lifecycle.MutableLiveData
import com.gang.module_base.BaseViewModel
import com.gang.module_user.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PwdViewModel : BaseViewModel() {
    private val repository = lazy { UserRepository() }

    val mobile = MutableLiveData<String>()
    val codeStr = MutableLiveData<String>()
    val pwd = MutableLiveData<String>()
    val pwd1 = MutableLiveData<String>()
    val getCodeStr = MutableLiveData<String>()

    init {
        mobile.postValue("")
        codeStr.postValue("")
        pwd.postValue("")
        pwd1.postValue("")
        getCodeStr.postValue("获取验证码")
    }

    var count = 60

    fun getCode() {
        if (count != 60) {
            return
        }
        if (mobile.value == null)
            return
        if (mobile.value.equals(""))
            return
        go {
            repository.value.getCode(mobile.value!!)
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