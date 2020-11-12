package com.gang.module_order.affirm

import androidx.lifecycle.MutableLiveData
import com.gang.lib_base.LogUtils
import com.gang.module_base.BaseViewModel
import com.gang.module_order.api.OrderRepository
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AffirmViewModel : BaseViewModel() {
    private val repository = lazy { OrderRepository() }

    val cartIds = MutableLiveData<String>()

    val affirmData = MutableLiveData<MutableList<AffirmEntity>>()
    val affirmBean = MutableLiveData<AffirmBean>()

    fun getAffirmOfCart() {
        go {
            withContext(Dispatchers.Default) {
                val result = repository.value.getAffirmOfCart(cartIds.value.toString())
                affirmBean.postValue(result[result.size - 1].bot)

                result.removeAt(result.size - 1)
                affirmData.postValue(result)
            }
        }
    }

    fun updateAddress(item: String) {
        // {"AddDate":"2020-09-16 21:06:13","City":"郑州市","County":"金水区","Id":"1676","IsDefault":false,"Mobile":"18888888888","Province":"河南","ReceiveName":"测试","address":"吃吃吃vv过","town":"人民路街道"}
        go {
            withContext(Dispatchers.Default){val gson = Gson()
                val address =
                    gson.fromJson<AffirmAddressBean>(item, AffirmAddressBean::class.java) ?: return@withContext
                LogUtils.print(address.toString())

                affirmData.value!![0].addressBean = address
                LogUtils.print("=1="+affirmData.value!!.toString())

                affirmData.postValue(affirmData.value!!)
                LogUtils.print("=2="+affirmData.value!!.toString())
            }
        }

    }
}