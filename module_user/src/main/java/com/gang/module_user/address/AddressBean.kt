package com.gang.module_user.address

import androidx.paging.PagedList
import java.io.Serializable

data class AddressBean(
    val addresslist: MutableList<AddressItemBean>,
    val addresslistP: PagedList<AddressItemBean>
)

data class AddressItemBean(
    var Id: String,
    var ReceiveName: String,
    var Mobile: String,
    var Province: String,
    var City: String,
    var County: String,
    var town: String,
    var address: String,
    var AddDate: String,
    var IsDefault: Boolean
) : Serializable