package com.gang.module_goods.list

import androidx.lifecycle.MutableLiveData
import com.gang.module_base.BaseViewModel
import com.gang.module_goods.GoodsRepository

class ListViewModel : BaseViewModel() {
    private var repository = lazy { GoodsRepository() }

    val key = MutableLiveData<String>()

    var page = 1

    val listData = MutableLiveData<MutableList<ListItemBean>>()

    init {
        key.value = "请输入关键词"
        listData.value = mutableListOf()
    }

    fun getData() {
        go {
            val result = repository.value.getGoodsList(page)
            listData.postValue(result)
        }
    }

}