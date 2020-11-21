package com.gang.module_user

import com.gang.lib_base.LogUtils
import com.gang.lib_base.HttpManager
import com.gang.module_base.BaseRepository
import com.gang.module_user.account.log.AccountLogBean
import com.gang.module_user.address.AddressBean
import com.gang.module_user.address.AddressItemBean
import com.gang.module_user.me.MeAccountBean
import com.gang.module_user.me.MeEntity
import com.gang.module_user.me.MeExtendBean
import com.gang.module_user.me.MeInfoBean
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class UserRepository : BaseRepository() {
    private var apiService = lazy {
        HttpManager.getInstance("http://xxx/")
            .getService(UserService::class.java)
    }

    suspend fun getUserInfo(): MutableList<MeEntity> {
        val result = mutableListOf<MeEntity>()

        val infoItem = MeEntity()
        infoItem.itemType = MeEntity.ITEM_TOP
        infoItem.meTopBean = MeInfoBean(
            "1", "http://47.97.124.87:9000/static/my/user.png",
            "昵称", "游客", "123456"
        )
        result.add(infoItem)
        val accountItem = MeEntity()
        accountItem.itemType = MeEntity.ITEM_ACCOUNT
        accountItem.meAccountBean = MeAccountBean(
            "1.00",
            "2.00",
            "3.00"
        )
        result.add(accountItem)

        val orderItem = MeEntity()
        orderItem.itemType = MeEntity.ITEM_ORDER
        result.add(orderItem)

        val extendItem = MeEntity()
        extendItem.itemType = MeEntity.ITEM_EXTEND
        val extendChild = mutableListOf<MeExtendBean>()
        extendChild.add(MeExtendBean(1, "收货地址"))
        extendChild.add(MeExtendBean(2, "分享"))
        extendItem.meExtends = extendChild
        result.add(extendItem)

        return result
    }

    suspend fun login(name: String, pwd: String): UserBean {
        if (name == "") {
            throw Exception("请输入手机号")
        }
        if (pwd == "") {
            throw Exception("请输入密码")
        }

        val data = apiService.value!!.getUserLogin(name, pwd)
        LogUtils.print(data.isSuccess().toString())
        if (data.isSuccess()) {
            return data.data
        }
        throw Exception(data.msg)
    }

    suspend fun getCode(mobile: String) {
        Thread.sleep(2000)
    }

    fun getAddressList(page: Int): MutableList<AddressItemBean> {
        val jsonStr =
            "{\"addresslist\":[{\"userId\":\"11206\",\"id\":\"1675\",\"addDate\":\"2020-09-16 21:05:39\",\"city\":\"郑州市\",\"county\":\"金水区\",\"postCode\":null,\"isDefault\":false,\"mobile\":\"18888888888\",\"address\":\"撤的啥\",\"receiveName\":\"测试12a2\",\"province\":\"河南省\",\"Id\":\"1675\",\"UserId\":\"11206\",\"ReceiveName\":\"测试12a2\",\"Province\":\"河南省\",\"City\":\"郑州市\",\"County\":\"金水区\",\"Address\":\"撤的啥\",\"PostCode\":null,\"Mobile\":\"18888888888\",\"IsDefault\":false,\"AddDate\":\"2020-09-16 21:05:39\",\"town\":\"经八路街道\"},{\"userId\":\"11206\",\"id\":\"1676\",\"addDate\":\"2020-09-16 21:06:13\",\"city\":\"郑州市\",\"county\":\"金水区\",\"postCode\":null,\"isDefault\":false,\"mobile\":\"18888888888\",\"address\":\"吃吃吃vv过\",\"receiveName\":\"测试\",\"province\":\"河南\",\"Id\":\"1676\",\"UserId\":\"11206\",\"ReceiveName\":\"测试\",\"Province\":\"河南\",\"City\":\"郑州市\",\"County\":\"金水区\",\"Address\":\"吃吃吃vv过\",\"PostCode\":null,\"Mobile\":\"18888888888\",\"IsDefault\":false,\"AddDate\":\"2020-09-16 21:06:13\",\"town\":\"人民路街道\"},{\"userId\":\"11206\",\"id\":\"1892\",\"addDate\":\"2020-10-13 14:57:01\",\"city\":\"郑州市\",\"county\":\"金水区\",\"postCode\":null,\"isDefault\":false,\"mobile\":\"18888888888\",\"address\":\"123123123123\",\"receiveName\":\"11111\",\"province\":\"河南省\",\"Id\":\"1892\",\"UserId\":\"11206\",\"ReceiveName\":\"11111\",\"Province\":\"河南省\",\"City\":\"郑州市\",\"County\":\"金水区\",\"Address\":\"123123123123\",\"PostCode\":null,\"Mobile\":\"18888888888\",\"IsDefault\":false,\"AddDate\":\"2020-10-13 14:57:01\",\"town\":\"经八路街道\"},{\"userId\":\"11206\",\"id\":\"1893\",\"addDate\":\"2020-10-13 14:58:24\",\"city\":\"郑州市\",\"county\":\"金水区\",\"postCode\":null,\"isDefault\":true,\"mobile\":\"18888888888\",\"address\":\"12161\",\"receiveName\":\"12222\",\"province\":\"河南省\",\"Id\":\"1893\",\"UserId\":\"11206\",\"ReceiveName\":\"12222\",\"Province\":\"河南省\",\"City\":\"郑州市\",\"County\":\"金水区\",\"Address\":\"12161\",\"PostCode\":null,\"Mobile\":\"18888888888\",\"IsDefault\":true,\"AddDate\":\"2020-10-13 14:58:24\",\"town\":\"经八路街道\"}]}"
        val gson = Gson()
        val addressBean = gson.fromJson<AddressBean>(jsonStr, AddressBean::class.java)
        if (addressBean == null)
            throw Exception("数据异常")
        return addressBean.addresslist
    }

    fun saveAddress(item: AddressItemBean) {
        if (item.ReceiveName == "")
            throw Exception("姓名不能为空")
        if (item.Mobile == "")
            throw Exception("手机号不能为空")
        if (item.Province == "")
            throw Exception("地区不能为空")
        if (item.address == "")
            throw Exception("详细地址不能为空")
    }

    suspend fun getAccountInfo(it: Int) {
    }

    suspend fun getAccountLog(page: Int): MutableList<AccountLogBean> =
        withContext(Dispatchers.IO) {
            val result = mutableListOf<AccountLogBean>()
            for (i in 0..100) {
                result.add(AccountLogBean("item$i"))
            }
            return@withContext result
        }
}