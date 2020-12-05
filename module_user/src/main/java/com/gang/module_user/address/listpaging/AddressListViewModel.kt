package com.gang.module_user.address.listpaging

import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.gang.module_base.BaseViewModel
import com.gang.module_user.UserRepository

class AddressListViewModel : BaseViewModel() {
        private var repository = lazy { UserRepository() }
    var isSelect = false

    fun getAddressData() = repository.value.getAddressList().cachedIn(viewModelScope).asLiveData()

}