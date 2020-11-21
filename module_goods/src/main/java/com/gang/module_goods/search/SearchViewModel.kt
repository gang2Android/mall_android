package com.gang.module_goods.search

import androidx.lifecycle.MutableLiveData
import com.gang.module_base.BaseViewModel

class SearchViewModel : BaseViewModel() {
    val searchKey = MutableLiveData<String>()

    fun search() {
        if (searchKey.value == null || searchKey.value == "")
            return

    }

}