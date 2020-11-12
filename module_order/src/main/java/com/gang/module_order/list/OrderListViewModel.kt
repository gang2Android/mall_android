package com.gang.module_order.list

import androidx.lifecycle.MutableLiveData
import com.gang.module_base.BaseViewModel
import com.gang.module_order.api.OrderRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class OrderListViewModel : BaseViewModel() {
    private var repository = lazy { OrderRepository() }

    val orderList = MutableLiveData<MutableList<OrderEntity>>()

    var page = 1
    var type = "1"

    fun getOrderList() {
        go {
            withContext(Dispatchers.Default) {
                val result = repository.value.getOrderList(page,type)
                orderList.postValue(result)
            }
        }
    }
}