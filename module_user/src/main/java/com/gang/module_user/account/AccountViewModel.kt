package com.gang.module_user.account

import androidx.lifecycle.MutableLiveData
import com.gang.module_base.BaseViewModel
import com.gang.module_user.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AccountViewModel : BaseViewModel() {
    private val repository = lazy { UserRepository() }

    val type = MutableLiveData<Int>()
    val typeStr = MutableLiveData<String>()
    val money = MutableLiveData<Double>()

    init {
        typeStr.value = "账户"
        money.value = 0.00
    }

    fun setType(it: Int) {
        type.postValue(it)
        when (it) {
            1 -> {
                typeStr.postValue("余额")
            }
            2 -> {
                typeStr.postValue("积分")
            }
            3 -> {
                typeStr.postValue("佣金")
            }
        }
        go {
            repository.value.getAccountInfo(it)
        }
    }

}