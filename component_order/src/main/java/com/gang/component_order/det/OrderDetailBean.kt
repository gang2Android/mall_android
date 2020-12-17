package com.gang.component_order.det

// {"id":10991,"userTel":"18888888888","receiveName":"12222","province":"河南省","city":"郑州市","county":"金水区","town":"经八路街道","address":"12161","goodsAmount":986.00,"orderAmount":986.00,"freight":0.00,"addDate":1603761758000,"outerOrderId":"1320898666360893440","block_hash":"https://www.vpubchain.info/h5/#/tracingDetail?dhash=7b7d7cfed6081d4a2737b0abf0bddc7e","status":10,"staname":"已取消","expname":null,"awbno":"","vvo":[{"proid":37132,"styleid":3134462,"proname":"威可（WQ-ii）男士提包 大容量旅行袋潮流时尚欧美 A089918073018","stylename":"红色--38*14*26","pronum":1,"price":986.00,"innerorderid":"1320898666360893440-2","spec_img":"http://www.999000.cn/data/files/store_2/goods_58/small_1598946458202009011547389603.jpg","vipPrice":986.00,"status":10,"img":"http://www.999000.cn/data/files/store_2/goods_58/small_1598946458202009011547389603.jpg","shop_type":2,"outerOrderId":"1320898666360893440"}]}

data class OrderDetailBean(
    val receiveName: String,
    val userTel: String,
    val province: String,
    val city: String,
    val county: String,
    val town: String,
    val address: String,

    val goodsAmount: String,
    val freight: String,
    val orderAmount: String,

    val addDate: String,
    val outerOrderId: String,

    val status: String,
    val staname: String,

    val expname: String,
    val awbno: String,

    val vvo: MutableList<OrderDetailProBean>
)

data class OrderDetailProBean(
    val proid: String,
    val proname: String,
    val spec_img: String,
    val styleid: String,
    val stylename: String,
    val price: String,
    val pronum: String,
    val innerorderid: String
)