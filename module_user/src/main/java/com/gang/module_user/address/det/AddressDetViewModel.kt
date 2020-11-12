package com.gang.module_user.address.det

import androidx.lifecycle.MutableLiveData
import com.gang.module_base.BaseViewModel
import com.gang.module_user.UserRepository
import com.gang.module_user.address.AddressItemBean
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class AddressDetViewModel : BaseViewModel() {
    private var repository = lazy { UserRepository() }

    val hint = MutableLiveData<String>()
    val item = MutableLiveData<AddressItemBean>()

    init {
        item.postValue(AddressItemBean("", "", "", "", "", "", "", "", "", false))
    }

    fun saveItem() {
        go {
            withContext(Dispatchers.Default) {
                try {
                    repository.value.saveAddress(item.value!!)
                } catch (e: Exception) {
                    hint.postValue(e.message)
                }
            }
        }
    }
}