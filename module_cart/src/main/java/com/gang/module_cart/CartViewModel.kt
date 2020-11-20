package com.gang.module_cart

import androidx.lifecycle.MutableLiveData
import com.gang.lib_base.NumArithUtils
import com.gang.module_base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CartViewModel : BaseViewModel() {
    private val repository = lazy { CartRepository() }

    val cartNum = MutableLiveData<String>()
    val isSelectAll = MutableLiveData<Boolean>()
    val selectPrice = MutableLiveData<String>()
    val selectNum = MutableLiveData<String>()

    val cartData = MutableLiveData<MutableList<CartEntity>>()

    init {
        cartNum.postValue("0")
        isSelectAll.postValue(false)
        selectPrice.postValue("0.00")
        selectNum.postValue("0")
    }

    fun getCartData() {
        go {
            val result = repository.value.getCartData()
            if (result.containsKey("num")) {
                cartNum.postValue(result["num"].toString())
            }
            if (result.containsKey("data")) {
                val data: MutableList<CartEntity> = result["data"] as MutableList<CartEntity>
                cartData.postValue(data)
            }
        }
    }

    fun selectAll() {
        go {
            val check = !(isSelectAll.value)!!
            val resultMap = repository.value.selectAll(cartData.value!!, check)
            if (resultMap.containsKey("price")) {
                selectPrice.postValue(resultMap["price"].toString())
            }
            if (resultMap.containsKey("num")) {
                selectNum.postValue(resultMap["num"].toString())
            }
            if (resultMap.containsKey("data")) {
                val data: MutableList<CartEntity> = resultMap["data"] as MutableList<CartEntity>
                cartData.postValue(data)
            }
            isSelectAll.postValue(check)
        }
    }

    fun selectSup(position: Int) {
        go {
            val resultMap = repository.value.selectSup(cartData.value!!, position)
            if (resultMap.containsKey("price")) {
                selectPrice.postValue(resultMap["price"].toString())
            }
            if (resultMap.containsKey("num")) {
                selectNum.postValue(resultMap["num"].toString())
            }
            if (resultMap.containsKey("selectAll")) {
                isSelectAll.postValue(resultMap["selectAll"] as Boolean)
            }
            if (resultMap.containsKey("data")) {
                val data: MutableList<CartEntity> = resultMap["data"] as MutableList<CartEntity>
                cartData.postValue(data)
            }
        }
    }

    fun selectPro(position: Int) {
        go {
            val resultMap = repository.value.selectPro(cartData.value!!, position)
            if (resultMap.containsKey("price")) {
                selectPrice.postValue(resultMap["price"].toString())
            }
            if (resultMap.containsKey("num")) {
                selectNum.postValue(resultMap["num"].toString())
            }
            if (resultMap.containsKey("selectAll")) {
                isSelectAll.postValue(resultMap["selectAll"] as Boolean)
            }
            if (resultMap.containsKey("data")) {
                val data: MutableList<CartEntity> = resultMap["data"] as MutableList<CartEntity>
                cartData.postValue(data)
            }
        }
    }

    fun goStore(position: Int) {
    }

    fun goPro(position: Int) {
    }
}