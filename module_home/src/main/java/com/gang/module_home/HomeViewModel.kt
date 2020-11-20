package com.gang.module_home

import androidx.lifecycle.MutableLiveData
import com.gang.module_base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HomeViewModel : BaseViewModel() {
    private val repository = HomeRepository()

    var homeEntity = MutableLiveData<MutableList<HomeEntity>>()

    fun getHomeData() {
        go {
            val result = repository.getHomeData()
            homeEntity.postValue(result)
        }
    }

}