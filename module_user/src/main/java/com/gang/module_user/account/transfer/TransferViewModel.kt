package com.gang.module_user.account.transfer

import androidx.lifecycle.MutableLiveData
import com.gang.module_base.BaseViewModel
import com.gang.module_user.UserRepository

class TransferViewModel : BaseViewModel() {
    private val repository = lazy { UserRepository() }

    val hint = MutableLiveData<String>()

    val type = MutableLiveData<String>()
    val money = MutableLiveData<Double>()

    val mobile = MutableLiveData<String>()
    val num = MutableLiveData<String>()
    val pwd = MutableLiveData<String>()

    init {
        mobile.value = ""
        num.value = ""
        pwd.value = ""
    }

    fun init(accountType: Int, accountMoney: Double) {
        when (accountType) {
            1 -> {
                type.postValue("余额：")
            }
            2 -> {
                type.postValue("积分：")
            }
            3 -> {
                type.postValue("佣金：")
            }
        }
        money.postValue(accountMoney)
    }

    fun affirm() {
        if (mobile.value == "") {
            return
        }
        if (num.value == "") {
            return
        }
        if (pwd.value == "") {
            return
        }
        hint.postValue("发起转账")
    }
}