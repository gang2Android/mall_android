package com.gang.module_goods.classify

import androidx.lifecycle.MutableLiveData
import com.gang.module_base.BaseViewModel
import com.gang.module_goods.GoodsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ClassifyViewModel : BaseViewModel() {
    private val repository = lazy { GoodsRepository() }

    val classifyData = MutableLiveData<MutableList<ClassifyBean>>()

    fun getClassifyData() {
        go {
            val result = repository.value.getClassifyData()
            classifyData.postValue(result)
        }
    }

}