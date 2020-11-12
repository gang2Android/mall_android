package com.gang.module_user.me

import androidx.lifecycle.MutableLiveData
import com.gang.lib_base.LogUtils
import com.gang.module_base.BaseViewModel
import com.gang.module_user.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MeViewModel : BaseViewModel() {
    private val repository = lazy { UserRepository() }

    val meData = MutableLiveData<MutableList<MeEntity>>()

    fun getUserInfo() {
        go {
            withContext(Dispatchers.Default) {
                val result = repository.value.getUserInfo()
                LogUtils.print("result=$result")
                meData.postValue(result)
            }
        }
    }
}