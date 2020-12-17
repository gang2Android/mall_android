package com.gang.component_order.pay

import androidx.lifecycle.MutableLiveData
import com.gang.module_base.BaseViewModel
import com.gang.component_order.api.OrderRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PayViewModel : BaseViewModel() {
    private var repository = lazy { OrderRepository() }

    var no = ""
    val payBean = MutableLiveData<PayBean>()

    fun getOrderPayInfo() {
        go {
            val result = repository.value.getOrderPayInfo(no)
            payBean.postValue(result)
        }
    }

}