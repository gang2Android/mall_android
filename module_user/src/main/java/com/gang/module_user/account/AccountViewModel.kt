package com.gang.module_user.account

import androidx.lifecycle.MutableLiveData
import com.gang.module_base.BaseViewModel
import com.gang.module_user.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AccountViewModel : BaseViewModel() {
    private val repository = lazy { UserRepository() }

    var type = MutableLiveData<String>()

    init {
        type.value = "账户"
    }

    fun setType(it: Int) {
        when (it) {
            1 -> {
                type.postValue("余额")
            }
            2 -> {
                type.postValue("积分")
            }
            3 -> {
                type.postValue("佣金")
            }
        }
        go {
            repository.value.getAccountInfo(it)
        }
    }

}