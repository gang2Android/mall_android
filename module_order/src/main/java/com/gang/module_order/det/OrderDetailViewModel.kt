package com.gang.module_order.det

import androidx.lifecycle.MutableLiveData
import com.gang.module_base.BaseViewModel
import com.gang.module_order.api.OrderRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class OrderDetailViewModel : BaseViewModel() {
    private var repository = lazy { OrderRepository() }

    val no = MutableLiveData<String>()
    val detailBean = MutableLiveData<MutableList<OrderDetailEntity>>()

    fun getOrderDetail() {
        go {
            val result = repository.value.getOrderDetail(no.value.toString())
            detailBean.postValue(result)
        }
    }

}