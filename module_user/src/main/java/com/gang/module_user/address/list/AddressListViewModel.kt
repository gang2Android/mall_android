package com.gang.module_user.address.list

import androidx.lifecycle.MutableLiveData
import com.gang.module_base.BaseViewModel
import com.gang.module_user.UserRepository
import com.gang.module_user.address.AddressItemBean
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AddressListViewModel : BaseViewModel() {
    private var repository = lazy { UserRepository() }

    val addressBean = MutableLiveData<MutableList<AddressItemBean>>()
    private var page = 1
    var isSelect = false

    fun getAddressList() {
        go {
            withContext(Dispatchers.Default) {
                val data = repository.value.getAddressList(page)
                addressBean.postValue(data)
            }
        }
    }

}