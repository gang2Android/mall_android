package com.gang.module_order.api

import com.gang.lib_base.LogUtils
import com.gang.module_base.BaseRepository
import com.gang.module_order.affirm.AffirmBean
import com.gang.module_order.affirm.AffirmEntity
import com.gang.module_order.det.*
import com.gang.module_order.list.OrderEntity
import com.gang.module_order.list.OrderListBean
import com.gang.module_order.pay.PayBean
import com.google.gson.Gson

class OrderRepository : BaseRepository() {
    suspend fun getOrderList(page: Int, type: String): MutableList<OrderEntity> {
        val jsonStr =
            "{\"is_third\":\"1\",\"list\":[{\"voo\":[{\"id\":13373,\"proid\":37132,\"styleid\":3134462,\"proname\":\"威可（WQ-ii）男士提包 大容量旅行袋潮流时尚欧美 A089918073018\",\"stylename\":\"红色--38*14*26\",\"pronum\":1,\"price\":986.00,\"consumeintegral\":0.00,\"innerorderid\":\"1320898666360893440-2\",\"spec_img\":\"http://www.999000.cn/data/files/store_2/goods_58/small_1598946458202009011547389603.jpg\",\"vipPrice\":986.00,\"status\":10,\"staname\":\"已取消\",\"evaluation_id\":null,\"img\":\"http://www.999000.cn/data/files/store_2/goods_58/small_1598946458202009011547389603.jpg\",\"block_hash\":\"7b7d7cfed6081d4a2737b0abf0bddc7e\",\"shop_type\":2,\"outerOrderId\":\"1320898666360893440\"}],\"userId\":\"11206\",\"id\":10991,\"province\":\"河南省\",\"city\":\"郑州市\",\"county\":\"金水区\",\"town\":\"经八路街道\",\"payMethod\":\"2\",\"address\":\"12161\",\"usertel\":\"18888888888\",\"status\":10,\"message\":\"\",\"adddate\":\"2020-10-27 09:22:38\",\"deliverdate\":null,\"awbno\":\"\",\"expcode\":\"\",\"expcompanyid\":0,\"innerorderid\":\"1320898666360893440-2\",\"supplierid\":2,\"receivename\":\"12222\",\"goodsamount\":986.00,\"freight\":0.00,\"orderamount\":986.00,\"consumeintegral\":0.00,\"adminmessage\":\"\",\"price\":3288.00,\"vipPrice\":null,\"isselflifting\":0,\"staname\":\"已取消\",\"supname\":\"精品区\",\"rate\":null,\"quanjiamsg\":null,\"goodsamountmsg\":null,\"zhekoujia\":null,\"shop_type\":2,\"isEvaluation\":null,\"isopeninvoice\":2,\"expressNos\":null,\"outerOrderId\":\"1320898666360893440\",\"orderType\":1},{\"voo\":[{\"id\":13130,\"proid\":35414,\"styleid\":3118343,\"proname\":\"测试商品不发货\",\"stylename\":\"默认\",\"pronum\":1,\"price\":100.00,\"consumeintegral\":0.00,\"innerorderid\":\"1319073679924875264-9\",\"spec_img\":\"https://jl-wg-chain.oss-cn-shenzhen.aliyuncs.com/ad/goods_b3761202008200753584840.jpg?x-oss-process=image/resize,w_400\",\"vipPrice\":100.00,\"status\":8,\"staname\":\"已收货\",\"evaluation_id\":null,\"img\":\"https://jl-wg-chain.oss-cn-shenzhen.aliyuncs.com/ad/goods_b3761202008200753584840.jpg?x-oss-process=image/resize,w_400\",\"block_hash\":\"0340a802d444fd0fb40c271075f225a4\",\"shop_type\":7,\"outerOrderId\":\"1319073679924875264\"}],\"userId\":\"11206\",\"id\":10814,\"province\":\"河南省\",\"city\":\"郑州市\",\"county\":\"金水区\",\"town\":\"经八路街道\",\"payMethod\":\"2\",\"address\":\"12161\",\"usertel\":\"18888888888\",\"status\":8,\"message\":\"\",\"adddate\":\"2020-10-22 08:30:47\",\"deliverdate\":1603326754000,\"awbno\":\"12121211\",\"expcode\":\"yunda\",\"expcompanyid\":1,\"innerorderid\":\"1319073679924875264-9\",\"supplierid\":9,\"receivename\":\"12222\",\"goodsamount\":100.00,\"freight\":0.00,\"orderamount\":100.00,\"consumeintegral\":0.00,\"adminmessage\":\"\",\"price\":50.00,\"vipPrice\":null,\"isselflifting\":0,\"staname\":\"已收货\",\"supname\":\"测试联盟商家\",\"rate\":null,\"quanjiamsg\":null,\"goodsamountmsg\":null,\"zhekoujia\":null,\"shop_type\":7,\"isEvaluation\":null,\"isopeninvoice\":0,\"expressNos\":null,\"outerOrderId\":\"1319073679924875264\",\"orderType\":1},{\"voo\":[{\"id\":12414,\"proid\":1363,\"styleid\":3095842,\"proname\":\"威可（WQ-ii）新款圆点胎牛皮女单肩包真皮时尚单肩包斜挎包链条包B089978026004\",\"stylename\":\"灰蓝--24.5*4*12CM\",\"pronum\":1,\"price\":1130.40,\"consumeintegral\":0.00,\"innerorderid\":\"1314967239341563904-2\",\"spec_img\":\"http://www.999000.cn/data/files/store_2/goods_185/small_1577499785201912281023053469.jpg\",\"vipPrice\":1130.40,\"status\":10,\"staname\":\"已取消\",\"evaluation_id\":null,\"img\":\"http://www.999000.cn/data/files/store_2/goods_185/small_1577499785201912281023053469.jpg\",\"block_hash\":\"1ac5eac6ae23d14611e20ddcf44756a9\",\"shop_type\":2,\"outerOrderId\":\"1314967239341563904\"}],\"userId\":\"11206\",\"id\":10349,\"province\":\"广东\",\"city\":\"广州市\",\"county\":\"黄埔区\",\"town\":\"文冲街道\",\"payMethod\":\"2\",\"address\":\"护林路1198号618、619房\",\"usertel\":\"18998328841\",\"status\":10,\"message\":\"\",\"adddate\":\"2020-10-11 00:33:15\",\"deliverdate\":null,\"awbno\":\"\",\"expcode\":\"\",\"expcompanyid\":0,\"innerorderid\":\"1314967239341563904-2\",\"supplierid\":2,\"receivename\":\"测试\",\"goodsamount\":1130.40,\"freight\":0.00,\"orderamount\":1130.40,\"consumeintegral\":0.00,\"adminmessage\":\"\",\"price\":3768.00,\"vipPrice\":null,\"isselflifting\":0,\"staname\":\"已取消\",\"supname\":\"精品区\",\"rate\":null,\"quanjiamsg\":null,\"goodsamountmsg\":null,\"zhekoujia\":null,\"shop_type\":2,\"isEvaluation\":null,\"isopeninvoice\":2,\"expressNos\":null,\"outerOrderId\":\"1314967239341563904\",\"orderType\":1},{\"voo\":[{\"id\":12413,\"proid\":381,\"styleid\":3096425,\"proname\":\"FOX菲可斯时尚百搭斜挎包男士单肩包A086909171004\",\"stylename\":\"黑色--33cm*10cm*25cm\",\"pronum\":1,\"price\":749.70,\"consumeintegral\":0.00,\"innerorderid\":\"1314966948290580480-2\",\"spec_img\":\"http://www.999000.cn/data/files/store_2/goods_43/small_1506741043201709301110435798.jpg\",\"vipPrice\":749.70,\"status\":10,\"staname\":\"已取消\",\"evaluation_id\":null,\"img\":\"http://www.999000.cn/data/files/store_2/goods_43/small_1506741043201709301110435798.jpg\",\"block_hash\":\"5158247bd4c580c44ad56bd6e1e66ab6\",\"shop_type\":2,\"outerOrderId\":\"1314966948290580480\"}],\"userId\":\"11206\",\"id\":10348,\"province\":\"广东\",\"city\":\"广州市\",\"county\":\"黄埔区\",\"town\":\"文冲街道\",\"payMethod\":\"2\",\"address\":\"护林路1198号618、619房\",\"usertel\":\"18998328841\",\"status\":10,\"message\":\"\",\"adddate\":\"2020-10-11 00:32:06\",\"deliverdate\":null,\"awbno\":\"\",\"expcode\":\"\",\"expcompanyid\":0,\"innerorderid\":\"1314966948290580480-2\",\"supplierid\":2,\"receivename\":\"测试\",\"goodsamount\":749.70,\"freight\":0.00,\"orderamount\":749.70,\"consumeintegral\":0.00,\"adminmessage\":\"\",\"price\":2499.00,\"vipPrice\":null,\"isselflifting\":0,\"staname\":\"已取消\",\"supname\":\"精品区\",\"rate\":null,\"quanjiamsg\":null,\"goodsamountmsg\":null,\"zhekoujia\":null,\"shop_type\":2,\"isEvaluation\":null,\"isopeninvoice\":2,\"expressNos\":null,\"outerOrderId\":\"1314966948290580480\",\"orderType\":1},{\"voo\":[{\"id\":12380,\"proid\":263,\"styleid\":3102015,\"proname\":\"fox男士单肩包斜挎包 男式蓝色斜挎包A086909175004\",\"stylename\":\"蓝色--33cm*10cm*25cm\",\"pronum\":1,\"price\":749.70,\"consumeintegral\":0.00,\"innerorderid\":\"1314855055165050880-2\",\"spec_img\":\"http://www.999000.cn/data/files/store_2/goods_128/small_201703151708488426.jpg\",\"vipPrice\":749.70,\"status\":10,\"staname\":\"已取消\",\"evaluation_id\":null,\"img\":\"http://www.999000.cn/data/files/store_2/goods_128/small_201703151708488426.jpg\",\"block_hash\":\"4e57a1610c2b3379affdafc9feb2c1b7\",\"shop_type\":2,\"outerOrderId\":\"1314855055165050880\"}],\"userId\":\"11206\",\"id\":10322,\"province\":\"广东\",\"city\":\"广州市\",\"county\":\"黄埔区\",\"town\":\"文冲街道\",\"payMethod\":\"3\",\"address\":\"护林路1198号618、619房\",\"usertel\":\"18998328841\",\"status\":10,\"message\":\"\",\"adddate\":\"2020-10-10 17:07:29\",\"deliverdate\":null,\"awbno\":\"\",\"expcode\":\"\",\"expcompanyid\":0,\"innerorderid\":\"1314855055165050880-2\",\"supplierid\":2,\"receivename\":\"测试\",\"goodsamount\":749.70,\"freight\":0.00,\"orderamount\":749.70,\"consumeintegral\":0.00,\"adminmessage\":\"\",\"price\":2499.00,\"vipPrice\":null,\"isselflifting\":0,\"staname\":\"已取消\",\"supname\":\"精品区\",\"rate\":null,\"quanjiamsg\":null,\"goodsamountmsg\":null,\"zhekoujia\":null,\"shop_type\":2,\"isEvaluation\":null,\"isopeninvoice\":2,\"expressNos\":null,\"outerOrderId\":\"1314855055165050880\",\"orderType\":1},{\"voo\":[{\"id\":12379,\"proid\":263,\"styleid\":3102015,\"proname\":\"fox男士单肩包斜挎包 男式蓝色斜挎包A086909175004\",\"stylename\":\"蓝色--33cm*10cm*25cm\",\"pronum\":1,\"price\":749.70,\"consumeintegral\":0.00,\"innerorderid\":\"1314854958494572544-2\",\"spec_img\":\"http://www.999000.cn/data/files/store_2/goods_128/small_201703151708488426.jpg\",\"vipPrice\":749.70,\"status\":10,\"staname\":\"已取消\",\"evaluation_id\":null,\"img\":\"http://www.999000.cn/data/files/store_2/goods_128/small_201703151708488426.jpg\",\"block_hash\":\"70607f368357ee5df10c468dbf07df6e\",\"shop_type\":2,\"outerOrderId\":\"1314854958494572544\"}],\"userId\":\"11206\",\"id\":10321,\"province\":\"广东\",\"city\":\"广州市\",\"county\":\"黄埔区\",\"town\":\"文冲街道\",\"payMethod\":\"2\",\"address\":\"护林路1198号618、619房\",\"usertel\":\"18998328841\",\"status\":10,\"message\":\"\",\"adddate\":\"2020-10-10 17:07:06\",\"deliverdate\":null,\"awbno\":\"\",\"expcode\":\"\",\"expcompanyid\":0,\"innerorderid\":\"1314854958494572544-2\",\"supplierid\":2,\"receivename\":\"测试\",\"goodsamount\":749.70,\"freight\":0.00,\"orderamount\":749.70,\"consumeintegral\":0.00,\"adminmessage\":\"\",\"price\":2499.00,\"vipPrice\":null,\"isselflifting\":0,\"staname\":\"已取消\",\"supname\":\"精品区\",\"rate\":null,\"quanjiamsg\":null,\"goodsamountmsg\":null,\"zhekoujia\":null,\"shop_type\":2,\"isEvaluation\":null,\"isopeninvoice\":2,\"expressNos\":null,\"outerOrderId\":\"1314854958494572544\",\"orderType\":1},{\"voo\":[{\"id\":12375,\"proid\":263,\"styleid\":3102015,\"proname\":\"fox男士单肩包斜挎包 男式蓝色斜挎包A086909175004\",\"stylename\":\"蓝色--33cm*10cm*25cm\",\"pronum\":1,\"price\":749.70,\"consumeintegral\":0.00,\"innerorderid\":\"1314847124671516672-2\",\"spec_img\":\"http://www.999000.cn/data/files/store_2/goods_128/small_201703151708488426.jpg\",\"vipPrice\":749.70,\"status\":10,\"staname\":\"已取消\",\"evaluation_id\":null,\"img\":\"http://www.999000.cn/data/files/store_2/goods_128/small_201703151708488426.jpg\",\"block_hash\":\"e558525f4eb60a580c7bc5546568b82a\",\"shop_type\":2,\"outerOrderId\":\"1314847124671516672\"}],\"userId\":\"11206\",\"id\":10317,\"province\":\"广东\",\"city\":\"广州市\",\"county\":\"黄埔区\",\"town\":\"文冲街道\",\"payMethod\":\"2\",\"address\":\"护林路1198号618、619房\",\"usertel\":\"18998328841\",\"status\":10,\"message\":\"\",\"adddate\":\"2020-10-10 16:35:58\",\"deliverdate\":null,\"awbno\":\"\",\"expcode\":\"\",\"expcompanyid\":0,\"innerorderid\":\"1314847124671516672-2\",\"supplierid\":2,\"receivename\":\"测试\",\"goodsamount\":749.70,\"freight\":0.00,\"orderamount\":749.70,\"consumeintegral\":0.00,\"adminmessage\":\"\",\"price\":2499.00,\"vipPrice\":null,\"isselflifting\":0,\"staname\":\"已取消\",\"supname\":\"精品区\",\"rate\":null,\"quanjiamsg\":null,\"goodsamountmsg\":null,\"zhekoujia\":null,\"shop_type\":2,\"isEvaluation\":null,\"isopeninvoice\":2,\"expressNos\":null,\"outerOrderId\":\"1314847124671516672\",\"orderType\":1},{\"voo\":[{\"id\":12371,\"proid\":263,\"styleid\":3102015,\"proname\":\"fox男士单肩包斜挎包 男式蓝色斜挎包A086909175004\",\"stylename\":\"蓝色--33cm*10cm*25cm\",\"pronum\":1,\"price\":749.70,\"consumeintegral\":0.00,\"innerorderid\":\"1314832743187435520-2\",\"spec_img\":\"http://www.999000.cn/data/files/store_2/goods_128/small_201703151708488426.jpg\",\"vipPrice\":749.70,\"status\":10,\"staname\":\"已取消\",\"evaluation_id\":null,\"img\":\"http://www.999000.cn/data/files/store_2/goods_128/small_201703151708488426.jpg\",\"block_hash\":\"da4234afe8969e00244c43af591fd3f2\",\"shop_type\":2,\"outerOrderId\":\"1314832743187435520\"}],\"userId\":\"11206\",\"id\":10313,\"province\":\"广东\",\"city\":\"广州市\",\"county\":\"黄埔区\",\"town\":\"文冲街道\",\"payMethod\":\"2\",\"address\":\"护林路1198号618、619房\",\"usertel\":\"18998328841\",\"status\":10,\"message\":\"\",\"adddate\":\"2020-10-10 15:38:49\",\"deliverdate\":null,\"awbno\":\"\",\"expcode\":\"\",\"expcompanyid\":0,\"innerorderid\":\"1314832743187435520-2\",\"supplierid\":2,\"receivename\":\"测试\",\"goodsamount\":749.70,\"freight\":0.00,\"orderamount\":749.70,\"consumeintegral\":0.00,\"adminmessage\":\"\",\"price\":2499.00,\"vipPrice\":null,\"isselflifting\":0,\"staname\":\"已取消\",\"supname\":\"精品区\",\"rate\":null,\"quanjiamsg\":null,\"goodsamountmsg\":null,\"zhekoujia\":null,\"shop_type\":2,\"isEvaluation\":null,\"isopeninvoice\":2,\"expressNos\":null,\"outerOrderId\":\"1314832743187435520\",\"orderType\":1},{\"voo\":[{\"id\":12370,\"proid\":263,\"styleid\":3102015,\"proname\":\"fox男士单肩包斜挎包 男式蓝色斜挎包A086909175004\",\"stylename\":\"蓝色--33cm*10cm*25cm\",\"pronum\":1,\"price\":749.70,\"consumeintegral\":0.00,\"innerorderid\":\"1314832571996758016-2\",\"spec_img\":\"http://www.999000.cn/data/files/store_2/goods_128/small_201703151708488426.jpg\",\"vipPrice\":749.70,\"status\":10,\"staname\":\"已取消\",\"evaluation_id\":null,\"img\":\"http://www.999000.cn/data/files/store_2/goods_128/small_201703151708488426.jpg\",\"block_hash\":\"a0e6b6ae768d62e9cf6a684632918397\",\"shop_type\":2,\"outerOrderId\":\"1314832571996758016\"}],\"userId\":\"11206\",\"id\":10312,\"province\":\"广东\",\"city\":\"广州市\",\"county\":\"黄埔区\",\"town\":\"文冲街道\",\"payMethod\":\"2\",\"address\":\"护林路1198号618、619房\",\"usertel\":\"18998328841\",\"status\":10,\"message\":\"\",\"adddate\":\"2020-10-10 15:38:08\",\"deliverdate\":null,\"awbno\":\"\",\"expcode\":\"\",\"expcompanyid\":0,\"innerorderid\":\"1314832571996758016-2\",\"supplierid\":2,\"receivename\":\"测试\",\"goodsamount\":749.70,\"freight\":0.00,\"orderamount\":749.70,\"consumeintegral\":0.00,\"adminmessage\":\"\",\"price\":2499.00,\"vipPrice\":null,\"isselflifting\":0,\"staname\":\"已取消\",\"supname\":\"精品区\",\"rate\":null,\"quanjiamsg\":null,\"goodsamountmsg\":null,\"zhekoujia\":null,\"shop_type\":2,\"isEvaluation\":null,\"isopeninvoice\":2,\"expressNos\":null,\"outerOrderId\":\"1314832571996758016\",\"orderType\":1},{\"voo\":[{\"id\":12335,\"proid\":263,\"styleid\":3102015,\"proname\":\"fox男士单肩包斜挎包 男式蓝色斜挎包A086909175004\",\"stylename\":\"蓝色--33cm*10cm*25cm\",\"pronum\":1,\"price\":749.70,\"consumeintegral\":0.00,\"innerorderid\":\"1314453291164950528-2\",\"spec_img\":\"http://www.999000.cn/data/files/store_2/goods_128/small_201703151708488426.jpg\",\"vipPrice\":749.70,\"status\":10,\"staname\":\"已取消\",\"evaluation_id\":null,\"img\":\"http://www.999000.cn/data/files/store_2/goods_128/small_201703151708488426.jpg\",\"block_hash\":\"d3c701d62baf14f5a2912daba8cbc50b\",\"shop_type\":2,\"outerOrderId\":\"1314453291164950528\"}],\"userId\":\"11206\",\"id\":10280,\"province\":\"广东\",\"city\":\"广州市\",\"county\":\"黄埔区\",\"town\":\"文冲街道\",\"payMethod\":\"3\",\"address\":\"护林路1198号618、619房\",\"usertel\":\"18998328841\",\"status\":10,\"message\":\"\",\"adddate\":\"2020-10-09 14:31:01\",\"deliverdate\":null,\"awbno\":\"\",\"expcode\":\"\",\"expcompanyid\":0,\"innerorderid\":\"1314453291164950528-2\",\"supplierid\":2,\"receivename\":\"测试\",\"goodsamount\":749.70,\"freight\":0.00,\"orderamount\":749.70,\"consumeintegral\":0.00,\"adminmessage\":\"\",\"price\":2499.00,\"vipPrice\":null,\"isselflifting\":0,\"staname\":\"已取消\",\"supname\":\"精品区\",\"rate\":null,\"quanjiamsg\":null,\"goodsamountmsg\":null,\"zhekoujia\":null,\"shop_type\":2,\"isEvaluation\":null,\"isopeninvoice\":2,\"expressNos\":null,\"outerOrderId\":\"1314453291164950528\",\"orderType\":1}]}"
        val gson = Gson()
        val orderListBean = gson.fromJson<OrderListBean>(jsonStr, OrderListBean::class.java)
        LogUtils.print(orderListBean.toString())
        val result = mutableListOf<OrderEntity>()
        orderListBean.list.forEach {
            val sup = OrderEntity()
            sup.itemType = OrderEntity.ITEM_SUP
            sup.sup = it
            result.add(sup)

            it.voo.forEach { v ->
                val pro = OrderEntity()
                pro.itemType = OrderEntity.ITEM_PRO
                pro.pro = v
                result.add(pro)
            }

            val bot = OrderEntity()
            bot.itemType = OrderEntity.ITEM_BOT
            bot.bot = it
            result.add(bot)
        }
        return result
    }

    suspend fun getOrderDetail(no: String): MutableList<OrderDetailEntity> {
        val jsonStr =
            "{\"id\":10991,\"userTel\":\"18888888888\",\"receiveName\":\"12222\",\"province\":\"河南省\",\"city\":\"郑州市\",\"county\":\"金水区\",\"town\":\"经八路街道\",\"address\":\"12161\",\"goodsAmount\":986.00,\"orderAmount\":986.00,\"freight\":0.00,\"addDate\":1603761758000,\"outerOrderId\":\"1320898666360893440\",\"block_hash\":\"https://www.vpubchain.info/h5/#/tracingDetail?dhash=7b7d7cfed6081d4a2737b0abf0bddc7e\",\"status\":10,\"staname\":\"已取消\",\"expname\":null,\"awbno\":\"\",\"vvo\":[{\"proid\":37132,\"styleid\":3134462,\"proname\":\"威可（WQ-ii）男士提包 大容量旅行袋潮流时尚欧美 A089918073018\",\"stylename\":\"红色--38*14*26\",\"pronum\":1,\"price\":986.00,\"innerorderid\":\"1320898666360893440-2\",\"spec_img\":\"http://www.999000.cn/data/files/store_2/goods_58/small_1598946458202009011547389603.jpg\",\"vipPrice\":986.00,\"status\":10,\"img\":\"http://www.999000.cn/data/files/store_2/goods_58/small_1598946458202009011547389603.jpg\",\"shop_type\":2,\"outerOrderId\":\"1320898666360893440\"}]}"
        val gson = Gson()
        val orderDetailBean = gson.fromJson<OrderDetailBean>(jsonStr, OrderDetailBean::class.java)
        val result = mutableListOf<OrderDetailEntity>()

        val statusEntity = OrderDetailEntity()
        statusEntity.statusBean =
            OrderDetailStatusBean(orderDetailBean.status, orderDetailBean.staname)
        statusEntity.itemType = OrderDetailEntity.ITEM_STATUS
        result.add(statusEntity)

        val addressEntity = OrderDetailEntity()
        addressEntity.addressBean =
            OrderDetailAddressBean(
                orderDetailBean.receiveName,
                orderDetailBean.userTel,
                orderDetailBean.province,
                orderDetailBean.city,
                orderDetailBean.county,
                orderDetailBean.town,
                orderDetailBean.address
            )
        addressEntity.itemType = OrderDetailEntity.ITEM_ADDRESS
        result.add(addressEntity)

        orderDetailBean.vvo.forEach {
            val proEntity = OrderDetailEntity()
            proEntity.proBean = it
            proEntity.itemType = OrderDetailEntity.ITEM_PRO
            result.add(proEntity)
        }

        val infoEntity = OrderDetailEntity()
        infoEntity.infoBean =
            OrderDetailInfoBean(
                orderDetailBean.outerOrderId,
                orderDetailBean.freight,
                orderDetailBean.orderAmount,
                orderDetailBean.addDate
            )
        infoEntity.itemType = OrderDetailEntity.ITEM_INFO
        result.add(infoEntity)

        return result
    }

    suspend fun getAffirmOfCart(cartIds: String): MutableList<AffirmEntity> {
        LogUtils.print("cartIds=${cartIds}")

        val jsonStr =
            "{\"id\":\"8711,9072\",\"pricetotal\":\"486.00\",\"ordermark\":\"1326002463043219456\",\"relist\":{\"Address\":\"12161\",\"town\":\"经八路街道\",\"ReceiveName\":\"12222\",\"Id\":1893,\"City\":\"郑州市\",\"County\":\"金水区\",\"Mobile\":\"18888888888\",\"Province\":\"河南省\"},\"groupcart\":[{\"supid\":\"7\",\"supname\":\"水黄金\",\"sspp\":\"286.00\",\"fregiht\":\"0.00\",\"voo\":[{\"img\":\"https://jl-wg-chain.oss-cn-shenzhen.aliyuncs.com/ad/goods_8276a202008151603438420.jpg?x-oss-process=image/resize,w_400\",\"proid\":\"29956\",\"proname\":\"恩施天然水黄金硒水570mlx24瓶天然弱碱高氧矿泉饮用水碱性\",\"pronum\":\"1\",\"shopprice\":\"286.00\",\"styleid\":\"2855324\",\"stylename\":\"默认\"}]},{\"supid\":\"21\",\"supname\":\"长沙双林服装设计有限公司\",\"sspp\":\"200.00\",\"fregiht\":\"0.00\",\"voo\":[{\"img\":\"https://jl-wg-chain.oss-cn-shenzhen.aliyuncs.com/ad/goods_ca616202009291315419127.jpg?x-oss-process=image/resize,w_400\",\"proid\":\"39913\",\"proname\":\"五常稻花香有机大米\",\"pronum\":\"1\",\"shopprice\":\"200.00\",\"styleid\":\"3137400\",\"stylename\":\"默认\"}]}]}"
        val gson = Gson()
        val bean = gson.fromJson<AffirmBean>(jsonStr, AffirmBean::class.java)
        val result = mutableListOf<AffirmEntity>()

        val addressItem = AffirmEntity()
        addressItem.itemType = AffirmEntity.ITEM_ADDRESS
        addressItem.addressBean = bean.relist
        result.add(addressItem)

        bean.groupcart.forEach {
            val supHeaderBean = AffirmEntity()
            supHeaderBean.itemType = AffirmEntity.ITEM_SUP_HEADER
            supHeaderBean.supBean = it
            result.add(supHeaderBean)

            it.voo.forEach { pro ->
                val proBean = AffirmEntity()
                proBean.itemType = AffirmEntity.ITEM_PRO
                proBean.proBean = pro
                result.add(proBean)
            }
            val supBotBean = AffirmEntity()
            supBotBean.itemType = AffirmEntity.ITEM_SUP_BOT
            supBotBean.supBean = it
            result.add(supBotBean)
        }
        val botBean = AffirmEntity()
        botBean.itemType = AffirmEntity.ITEM_BOT
        botBean.bot = bean
        result.add(botBean)

        return result
    }

    suspend fun getOrderPayInfo(no: String): PayBean {
        val jsonStr = "{\"no\":\"13123123\",\"fright\":\"0.00\",\"price\":\"1.00\"}"
        val gson = Gson()
        return gson.fromJson(jsonStr, PayBean::class.java)
    }

}