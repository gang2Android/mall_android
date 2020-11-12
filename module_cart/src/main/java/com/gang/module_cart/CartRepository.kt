package com.gang.module_cart

import com.gang.lib_base.NumArithUtils
import com.gang.module_base.BaseRepository
import com.google.gson.Gson

class CartRepository : BaseRepository() {
    fun getCartData(): MutableMap<String, Any> {
        val jsonStr =
            "{\"sum_money\":\"2360.4\",\"sum_integral\":\"0.0\",\"sum_giveintegral\":\"0.0\",\"goods_num\":\"4\",\"data_list\":[{\"supid\":\"3\",\"supname\":\"精品区\",\"sub\":[{\"proid\":\"243\",\"shopprice\":\"110.40\",\"consumeintegral\":\"0.00\",\"giveintegral\":\"0.00\",\"id\":\"6803\",\"status\":\"1\",\"proname\":\"WQii威可 男士商务皮带经典男士自动扣皮带开A089935208\",\"stylename\":\"110*3.5CM\",\"pronum\":\"1\",\"proimg\":\"http://www.999000.cn/data/files/store_2/goods_28/small_1572941828201911051617084020.jpg\",\"isonsell\":\"0\",\"balancePrice\":368,\"lfz\":66.24},{\"proid\":\"381\",\"shopprice\":\"750.00\",\"consumeintegral\":\"0.00\",\"giveintegral\":\"0.00\",\"id\":\"8991\",\"status\":\"1\",\"proname\":\"FOX菲可斯时尚百搭斜挎包男士单肩包A086909171004\",\"stylename\":\"33cm*10cm*25cm\",\"pronum\":\"3\",\"proimg\":\"http://www.999000.cn/data/files/store_2/goods_43/small_1506741043201709301110435798.jpg\",\"isonsell\":\"1\",\"balancePrice\":2499,\"lfz\":599}]},{\"supid\":\"2\",\"supname\":\"精品区\",\"sub\":[{\"proid\":\"243\",\"shopprice\":\"110.40\",\"consumeintegral\":\"0.00\",\"giveintegral\":\"0.00\",\"id\":\"6803\",\"status\":\"1\",\"proname\":\"WQii威可 男士商务皮带经典男士自动扣皮带开A089935208\",\"stylename\":\"110*3.5CM\",\"pronum\":\"1\",\"proimg\":\"http://www.999000.cn/data/files/store_2/goods_28/small_1572941828201911051617084020.jpg\",\"isonsell\":\"0\",\"balancePrice\":368,\"lfz\":66.24},{\"proid\":\"381\",\"shopprice\":\"750.00\",\"consumeintegral\":\"0.00\",\"giveintegral\":\"0.00\",\"id\":\"8991\",\"status\":\"1\",\"proname\":\"FOX菲可斯时尚百搭斜挎包男士单肩包A086909171004\",\"stylename\":\"33cm*10cm*25cm\",\"pronum\":\"3\",\"proimg\":\"http://www.999000.cn/data/files/store_2/goods_43/small_1506741043201709301110435798.jpg\",\"isonsell\":\"1\",\"balancePrice\":2499,\"lfz\":599}]}]}"
        val gson = Gson()
        val cartBean = gson.fromJson<CartBean>(jsonStr, CartBean::class.java)

        val resultMap = mutableMapOf<String, Any>()
        val result = mutableListOf<CartEntity>()
        cartBean.data_list.forEach { sup ->
            val supItem = CartEntity()
            supItem.supBean = sup
            supItem.itemType = CartEntity.ITEM_SUP
            result.add(supItem)

            sup.sub.forEach { pro ->
                val proItem = CartEntity()
                pro.sid = sup.supid
                proItem.proBean = pro
                proItem.itemType = CartEntity.ITEM_PRO
                result.add(proItem)
            }
        }
        resultMap["data"] = result
        resultMap["num"] = cartBean.goods_num

        return resultMap
    }

    fun selectAll(list: MutableList<CartEntity>, check: Boolean): MutableMap<String, Any> {

        val data = mutableListOf<CartEntity>()
        data.addAll(list)

        val resultMap = mutableMapOf<String, Any>()
        var price = "0.00"
        var num = "0"
        data.forEach {
            when (it.itemType) {
                CartEntity.ITEM_SUP -> {
                    it.supBean!!.isCheck = check
                }
                CartEntity.ITEM_PRO -> {
                    it.proBean!!.isCheck = check
                    if (check) {
                        val itemPrice =
                            NumArithUtils.mul(it.proBean!!.shopprice, it.proBean!!.pronum)
                        price = NumArithUtils.add(price, itemPrice)
                        num = NumArithUtils.add(num, "1", scale = 0)
                    }
                }
            }
        }
        resultMap["data"] = data
        resultMap["price"] = price
        resultMap["num"] = num
        return resultMap
    }

    fun selectSup(data: MutableList<CartEntity>, position: Int): MutableMap<String, Any> {
        val resultMap = mutableMapOf<String, Any>()
        var price = "0.00"
        var num = "0"
        var supCount = 0
        var trueCount = 0
        var falseCount = 0
        val item = data[position]
        item.supBean!!.isCheck = !item.supBean!!.isCheck
        data.forEach {
            when (it.itemType) {
                CartEntity.ITEM_SUP -> {
                    supCount += 1
                    if (it.supBean!!.isCheck) {
                        trueCount += 1
                    } else {
                        falseCount += 1
                    }
                }
                CartEntity.ITEM_PRO -> {
                    if (it.proBean!!.sid == item.supBean!!.supid) {
                        it.proBean!!.isCheck = item.supBean!!.isCheck
                    }
                    if (it.proBean!!.isCheck) {
                        val itemPrice =
                            NumArithUtils.mul(it.proBean!!.shopprice, it.proBean!!.pronum)
                        price = NumArithUtils.add(price, itemPrice)
                        num = NumArithUtils.add(num, "1", scale = 0)
                    }
                }
            }
        }
        resultMap["data"] = data
        resultMap["price"] = price
        resultMap["num"] = num
        resultMap["selectAll"] = supCount == trueCount
        return resultMap
    }

    fun selectPro(data: MutableList<CartEntity>, position: Int): MutableMap<String, Any> {
        val resultMap = mutableMapOf<String, Any>()
        var price = "0.00"
        var num = "0"
        val item = data[position]
        item.proBean!!.isCheck = !item.proBean!!.isCheck
        var itemCount = 0
        var trueCount = 0
        var falseCount = 0
        data.forEach {
            when (it.itemType) {
                CartEntity.ITEM_PRO -> {
                    if (it.proBean!!.sid == item.proBean!!.sid) {
                        itemCount += 1
                        if (it.proBean!!.isCheck) {
                            trueCount += 1
                        } else {
                            falseCount += 1
                        }
                    }
                    if (it.proBean!!.isCheck) {
                        val itemPrice =
                            NumArithUtils.mul(it.proBean!!.shopprice, it.proBean!!.pronum)
                        price = NumArithUtils.add(price, itemPrice)
                        num = NumArithUtils.add(num, "1", scale = 0)
                    }
                }
            }
        }
        val checked = itemCount == trueCount

        itemCount = 0
        trueCount = 0
        falseCount = 0
        data.forEach {
            when (it.itemType) {
                CartEntity.ITEM_SUP -> {
                    itemCount += 1
                    if (it.supBean!!.supid == item.proBean!!.sid) {
                        it.supBean!!.isCheck = checked
                    }
                    if (it.supBean!!.isCheck) {
                        trueCount += 1
                    } else {
                        falseCount += 1
                    }
                }
            }
        }
        resultMap["data"] = data
        resultMap["price"] = price
        resultMap["num"] = num
        resultMap["selectAll"] = itemCount == trueCount
        return resultMap
    }
}