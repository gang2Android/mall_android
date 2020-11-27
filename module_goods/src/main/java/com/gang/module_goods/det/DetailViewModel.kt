package com.gang.module_goods.det

import androidx.lifecycle.MutableLiveData
import com.gang.module_base.BaseViewModel
import com.gang.module_goods.GoodsRepository

class DetailViewModel : BaseViewModel() {
    private var repository = lazy { GoodsRepository() }

    val detailBean = MutableLiveData<DetailBean>()
    val detailEntity = MutableLiveData<MutableList<DetailEntity>>()

    fun getDetail(proId: String) {
        go {
            val result = repository.value.getGoodsDetail(proId)
            detailEntity.postValue(result)
        }
    }

}