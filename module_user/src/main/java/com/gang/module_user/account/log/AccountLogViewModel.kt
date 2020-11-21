package com.gang.module_user.account.log

import androidx.lifecycle.MutableLiveData
import com.gang.module_base.BaseViewModel
import com.gang.module_user.UserRepository

class AccountLogViewModel : BaseViewModel() {
    private var repository = lazy { UserRepository() }

    val page = 1

    val type = MutableLiveData<Int>()
    val typeStr = MutableLiveData<String>()

    val accountLogList = MutableLiveData<MutableList<AccountLogBean>>()

    init {
        typeStr.value = ""
        accountLogList.value = mutableListOf()
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
    }

    fun getData() {
        go {
            val data = repository.value.getAccountLog(page)
            accountLogList.postValue(data)
        }
    }

}