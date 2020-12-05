package com.gang.module_user.address.listpaging

import androidx.paging.PagingSource
import com.gang.lib_base.LogUtils
import com.gang.module_user.address.AddressBean
import com.gang.module_user.address.AddressItemBean
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class AddressDataSource : PagingSource<Int, AddressItemBean>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, AddressItemBean> {
        val page = params.key ?: 1

        val result = getData()
        LogUtils.print("nam1e=${Thread.currentThread().name}")
        return if (page == 10) {
            LoadResult.Page(data = result, prevKey = null, nextKey = null)
        } else {
            LoadResult.Page(data = result, prevKey = null, nextKey = page + 1)
        }
    }

    private suspend fun getData() = withContext(Dispatchers.IO) {
        val jsonStr =
            "{\"addresslist\":[{\"userId\":\"11206\",\"id\":\"1675\",\"addDate\":\"2020-09-16 21:05:39\",\"city\":\"郑州市\",\"county\":\"金水区\",\"postCode\":null,\"isDefault\":false,\"mobile\":\"18888888888\",\"address\":\"撤的啥\",\"receiveName\":\"测试12a2\",\"province\":\"河南省\",\"Id\":\"1675\",\"UserId\":\"11206\",\"ReceiveName\":\"测试12a2\",\"Province\":\"河南省\",\"City\":\"郑州市\",\"County\":\"金水区\",\"Address\":\"撤的啥\",\"PostCode\":null,\"Mobile\":\"18888888888\",\"IsDefault\":false,\"AddDate\":\"2020-09-16 21:05:39\",\"town\":\"经八路街道\"},{\"userId\":\"11206\",\"id\":\"1676\",\"addDate\":\"2020-09-16 21:06:13\",\"city\":\"郑州市\",\"county\":\"金水区\",\"postCode\":null,\"isDefault\":false,\"mobile\":\"18888888888\",\"address\":\"吃吃吃vv过\",\"receiveName\":\"测试\",\"province\":\"河南\",\"Id\":\"1676\",\"UserId\":\"11206\",\"ReceiveName\":\"测试\",\"Province\":\"河南\",\"City\":\"郑州市\",\"County\":\"金水区\",\"Address\":\"吃吃吃vv过\",\"PostCode\":null,\"Mobile\":\"18888888888\",\"IsDefault\":false,\"AddDate\":\"2020-09-16 21:06:13\",\"town\":\"人民路街道\"},{\"userId\":\"11206\",\"id\":\"1892\",\"addDate\":\"2020-10-13 14:57:01\",\"city\":\"郑州市\",\"county\":\"金水区\",\"postCode\":null,\"isDefault\":false,\"mobile\":\"18888888888\",\"address\":\"123123123123\",\"receiveName\":\"11111\",\"province\":\"河南省\",\"Id\":\"1892\",\"UserId\":\"11206\",\"ReceiveName\":\"11111\",\"Province\":\"河南省\",\"City\":\"郑州市\",\"County\":\"金水区\",\"Address\":\"123123123123\",\"PostCode\":null,\"Mobile\":\"18888888888\",\"IsDefault\":false,\"AddDate\":\"2020-10-13 14:57:01\",\"town\":\"经八路街道\"},{\"userId\":\"11206\",\"id\":\"1893\",\"addDate\":\"2020-10-13 14:58:24\",\"city\":\"郑州市\",\"county\":\"金水区\",\"postCode\":null,\"isDefault\":true,\"mobile\":\"18888888888\",\"address\":\"12161\",\"receiveName\":\"12222\",\"province\":\"河南省\",\"Id\":\"1893\",\"UserId\":\"11206\",\"ReceiveName\":\"12222\",\"Province\":\"河南省\",\"City\":\"郑州市\",\"County\":\"金水区\",\"Address\":\"12161\",\"PostCode\":null,\"Mobile\":\"18888888888\",\"IsDefault\":true,\"AddDate\":\"2020-10-13 14:58:24\",\"town\":\"经八路街道\"}]}"
        val gson = Gson()
        val addressBean = gson.fromJson<AddressBean>(jsonStr, AddressBean::class.java)
        if (addressBean == null)
            throw Exception("数据异常")
        val result = addressBean.addresslist

        LogUtils.print("name=${Thread.currentThread().name}")
        Thread.sleep(2000)

        return@withContext result
    }

}