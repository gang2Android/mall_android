package com.gang.component_order.affirm

// {"id":"8711,9072","pricetotal":"486.00","ordermark":"1326002463043219456","relist":{"Address":"12161","town":"经八路街道","ReceiveName":"12222","Id":1893,"City":"郑州市","County":"金水区","Mobile":"18888888888","Province":"河南省"},"groupcart":[{"supid":"7","supname":"水黄金","sspp":"286.00","fregiht":"0.00","voo":[{"img":"https://jl-wg-chain.oss-cn-shenzhen.aliyuncs.com/ad/goods_8276a202008151603438420.jpg?x-oss-process=image/resize,w_400","proid":"29956","proname":"恩施天然水黄金硒水570mlx24瓶天然弱碱高氧矿泉饮用水碱性","pronum":"1","shopprice":"286.00","styleid":"2855324","stylename":"默认"}]},{"supid":"21","supname":"长沙双林服装设计有限公司","sspp":"200.00","fregiht":"0.00","voo":[{"img":"https://jl-wg-chain.oss-cn-shenzhen.aliyuncs.com/ad/goods_ca616202009291315419127.jpg?x-oss-process=image/resize,w_400","proid":"39913","proname":"五常稻花香有机大米","pronum":"1","shopprice":"200.00","styleid":"3137400","stylename":"默认"}]}]}

data class AffirmBean(
    val ordermark: String,

    val id: String,
    val pricetotal: String,

    val relist: AffirmAddressBean,

    val groupcart: MutableList<AffirmSupBean>
)

data class AffirmAddressBean(
    val Id: String,
    val ReceiveName: String,
    val Mobile: String,
    val Province: String,
    val City: String,
    val County: String,
    val town: String,
    val Address: String
)

data class AffirmSupBean(
    val supid: String,
    val supname: String,
    val fregiht: String,
    val sspp: String,
    val voo: MutableList<AffirmProBean>
)

data class AffirmProBean(
    val proid: String,
    val proname: String,
    val img: String,
    val styleid: String,
    val stylename: String,
    val shopprice: String,
    val pronum: String
)