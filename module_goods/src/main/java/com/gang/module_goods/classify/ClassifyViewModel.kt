package com.gang.module_goods.classify

import androidx.lifecycle.MutableLiveData
import com.gang.module_base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ClassifyViewModel : BaseViewModel() {
    private val repository = ClassifyRepository()

    val classifyData = MutableLiveData<MutableList<ClassifyBean>>()

    fun getClassifyData() {
        go {
            val result = repository.getClassifyData()
            classifyData.postValue(result)
        }
    }

}