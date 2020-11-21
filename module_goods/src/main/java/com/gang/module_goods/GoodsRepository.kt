package com.gang.module_goods

import com.gang.lib_base.HttpManager
import com.gang.module_base.BaseRepository
import com.gang.module_goods.classify.ClassifyBean
import com.gang.module_goods.det.DetailBean
import com.gang.module_goods.list.ListBean
import com.gang.module_goods.list.ListItemBean
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GoodsRepository : BaseRepository() {
    private var apiService = lazy {
        HttpManager.getInstance("http://xxx/")
            .getService(GoodsService::class.java)
    }

    suspend fun getClassifyData(): MutableList<ClassifyBean> = withContext(Dispatchers.IO) {
        val jsonStr =
            "[{\"id\":63,\"pid\":0,\"photo\":\"http://shop.mall.345678.com.cn//public/uploads/dd019a7a09ca814a0c4c28861bfe81b5.png\",\"name\":\"箱包皮具\",\"children\":[{\"id\":2301,\"pid\":63,\"photo\":\"http://www.999000.cn/data/files/class_poster/1540881940201810301445402471.jpg\",\"name\":\"男包\",\"children\":[{\"id\":2343,\"pid\":2301,\"photo\":\"http://www.999000.cn/data/files/class_poster/1543818307201812031425079190.jpg\",\"name\":\"编织纹\",\"children\":null},{\"id\":2344,\"pid\":2301,\"photo\":\"http://www.999000.cn/data/files/class_poster/1543818322201812031425224556.jpg\",\"name\":\"鳄鱼纹\",\"children\":null},{\"id\":2345,\"pid\":2301,\"photo\":\"http://www.999000.cn/data/files/class_poster/1543818339201812031425393525.jpg\",\"name\":\"鸵鸟纹\",\"children\":null},{\"id\":2354,\"pid\":2301,\"photo\":\"http://www.999000.cn/data/files/class_poster/1543818352201812031425526086.jpg\",\"name\":\"FOX\",\"children\":null}]},{\"id\":2302,\"pid\":63,\"photo\":\"http://www.999000.cn/data/files/class_poster/1540881953201810301445539609.jpg\",\"name\":\"女包\",\"children\":[{\"id\":2355,\"pid\":2302,\"photo\":\"http://www.999000.cn/data/files/class_poster/1543818430201812031427107373.jpg\",\"name\":\"FOX\",\"children\":null},{\"id\":2356,\"pid\":2302,\"photo\":\"http://www.999000.cn/data/files/class_poster/1543818370201812031426102858.jpg\",\"name\":\"编织纹\",\"children\":null},{\"id\":2357,\"pid\":2302,\"photo\":\"http://www.999000.cn/data/files/class_poster/1543818383201812031426239598.jpg\",\"name\":\"鸵鸟纹\",\"children\":null},{\"id\":2358,\"pid\":2302,\"photo\":\"http://www.999000.cn/data/files/class_poster/1543818398201812031426386202.jpg\",\"name\":\"鳄鱼纹\",\"children\":null},{\"id\":2359,\"pid\":2302,\"photo\":\"http://www.999000.cn/data/files/class_poster/1543818416201812031426566558.jpg\",\"name\":\"WQII\",\"children\":null}]},{\"id\":2303,\"pid\":63,\"photo\":\"http://www.999000.cn/data/files/class_poster/1540881964201810301446041080.jpg\",\"name\":\"腰带\",\"children\":null},{\"id\":2335,\"pid\":63,\"photo\":\"http://www.999000.cn/data/files/class_poster/1540881974201810301446144385.jpg\",\"name\":\"拉杆箱\",\"children\":null}]},{\"id\":2255,\"pid\":0,\"photo\":\"http://shop.mall.345678.com.cn//public/uploads/b931d9a4067575ff4a1729a71c4fe4c7.png\",\"name\":\"珠宝首饰\",\"children\":[{\"id\":2257,\"pid\":2255,\"photo\":\"http://www.999000.cn/data/files/class_poster/1568621835201909161617154102.jpg\",\"name\":\"项链吊坠\",\"children\":[{\"id\":2363,\"pid\":2257,\"photo\":\"http://www.999000.cn/data/files/class_poster/1543891423201812041043438753.jpg\",\"name\":\"六世缘\",\"children\":null},{\"id\":2364,\"pid\":2257,\"photo\":\"http://www.999000.cn/data/files/class_poster/1543891438201812041043584825.jpg\",\"name\":\"亨德利\",\"children\":null},{\"id\":2423,\"pid\":2257,\"photo\":\"http://www.999000.cn/data/files/class_poster/1558583967201905231159278513.jpg\",\"name\":\"JUJU\",\"children\":null}]},{\"id\":2259,\"pid\":2255,\"photo\":\"http://www.999000.cn/data/files/class_poster/1557048961201905051736011848.jpg\",\"name\":\"耳饰\",\"children\":null},{\"id\":2260,\"pid\":2255,\"photo\":\"http://www.999000.cn/data/files/class_poster/1568619435201909161537154332.jpg\",\"name\":\"钻石系列\",\"children\":null},{\"id\":2342,\"pid\":2255,\"photo\":\"http://www.999000.cn/data/files/class_poster/1540882025201810301447053058.jpg\",\"name\":\"胸针\",\"children\":null},{\"id\":2421,\"pid\":2255,\"photo\":\"http://www.999000.cn/data/files/class_poster/1557048860201905051734202453.jpg\",\"name\":\"手链\",\"children\":null},{\"id\":2434,\"pid\":2255,\"photo\":\"http://www.999000.cn/data/files/class_poster/1568619504201909161538244322.jpg\",\"name\":\"戒指\",\"children\":null},{\"id\":2435,\"pid\":2255,\"photo\":\"http://www.999000.cn/data/files/class_poster/1572946780201911051739402191.jpg\",\"name\":\"手表\",\"children\":null}]},{\"id\":2304,\"pid\":0,\"photo\":\"http://shop.mall.345678.com.cn//public/uploads/e605c70c44a66ecd7f14158df41a5ec9.png\",\"name\":\"男装\",\"children\":[{\"id\":2382,\"pid\":2304,\"photo\":\"http://www.999000.cn/data/files/class_poster/1543051167201811241719274918.jpg\",\"name\":\"秋冬\",\"children\":[{\"id\":2383,\"pid\":2382,\"photo\":\"http://www.999000.cn/data/files/class_poster/1543213200201811261420007056.jpg\",\"name\":\"羽绒服\",\"children\":null},{\"id\":2384,\"pid\":2382,\"photo\":\"http://www.999000.cn/data/files/class_poster/1543213060201811261417404057.jpg\",\"name\":\"棉服\",\"children\":null},{\"id\":2385,\"pid\":2382,\"photo\":\"http://www.999000.cn/data/files/class_poster/1543213075201811261417559282.jpg\",\"name\":\"大衣\",\"children\":null},{\"id\":2386,\"pid\":2382,\"photo\":\"http://www.999000.cn/data/files/class_poster/1543213091201811261418113554.jpg\",\"name\":\"皮草\",\"children\":null},{\"id\":2387,\"pid\":2382,\"photo\":\"http://www.999000.cn/data/files/class_poster/1543213106201811261418262022.jpg\",\"name\":\"毛衫\",\"children\":null},{\"id\":2388,\"pid\":2382,\"photo\":\"http://www.999000.cn/data/files/class_poster/1543213118201811261418386071.jpg\",\"name\":\"西服/马甲\",\"children\":null},{\"id\":2389,\"pid\":2382,\"photo\":\"http://www.999000.cn/data/files/class_poster/1543213135201811261418553750.jpg\",\"name\":\"茄克/风衣\",\"children\":null},{\"id\":2390,\"pid\":2382,\"photo\":\"http://www.999000.cn/data/files/class_poster/1543213147201811261419072128.jpg\",\"name\":\"长袖衬衫\",\"children\":null},{\"id\":2391,\"pid\":2382,\"photo\":\"http://www.999000.cn/data/files/class_poster/1543213161201811261419214080.jpg\",\"name\":\"卫衣/长袖/T恤\",\"children\":null},{\"id\":2392,\"pid\":2382,\"photo\":\"http://www.999000.cn/data/files/class_poster/1543213172201811261419327859.jpg\",\"name\":\"休闲裤\",\"children\":null},{\"id\":2393,\"pid\":2382,\"photo\":\"http://www.999000.cn/data/files/class_poster/1543213188201811261419483593.jpg\",\"name\":\"牛仔裤\",\"children\":null},{\"id\":7335,\"pid\":2382,\"photo\":\"http://www.999000.cn/data/files/class_poster/1577495833201912280917138426.jpg\",\"name\":\"高定系列\",\"children\":null}]},{\"id\":2394,\"pid\":2304,\"photo\":\"http://www.999000.cn/data/files/class_poster/1543213224201811261420242743.jpg\",\"name\":\"春夏\",\"children\":[{\"id\":2395,\"pid\":2394,\"photo\":\"http://www.999000.cn/data/files/class_poster/1543213240201811261420401716.jpg\",\"name\":\"T恤\",\"children\":null},{\"id\":2396,\"pid\":2394,\"photo\":\"http://www.999000.cn/data/files/class_poster/1543213252201811261420524687.jpg\",\"name\":\"衬衫\",\"children\":null},{\"id\":2397,\"pid\":2394,\"photo\":\"http://www.999000.cn/data/files/class_poster/1543213262201811261421023049.jpg\",\"name\":\"牛仔裤\",\"children\":null},{\"id\":2398,\"pid\":2394,\"photo\":\"http://www.999000.cn/data/files/class_poster/1543213272201811261421124870.jpg\",\"name\":\"休闲裤\",\"children\":null},{\"id\":2418,\"pid\":2394,\"photo\":\"http://www.999000.cn/data/files/class_poster/1556328149201904270922291058.jpg\",\"name\":\"外套\",\"children\":null}]}]},{\"id\":2311,\"pid\":0,\"photo\":\"http://shop.mall.345678.com.cn//public/uploads/3d1876a4f4593d3489ed0435b7e75f02.png\",\"name\":\"女装\",\"children\":[{\"id\":2365,\"pid\":2311,\"photo\":\"http://www.999000.cn/data/files/class_poster/1543051136201811241718563031.jpg\",\"name\":\"秋冬\",\"children\":[{\"id\":2367,\"pid\":2365,\"photo\":\"http://www.999000.cn/data/files/class_poster/1543202437201811261120374394.jpg\",\"name\":\"羽绒服\",\"children\":null},{\"id\":2368,\"pid\":2365,\"photo\":\"http://www.999000.cn/data/files/class_poster/1543202448201811261120483832.jpg\",\"name\":\"大衣\",\"children\":null},{\"id\":2370,\"pid\":2365,\"photo\":\"http://www.999000.cn/data/files/class_poster/1543202461201811261121018776.jpg\",\"name\":\"毛衫\",\"children\":null},{\"id\":2371,\"pid\":2365,\"photo\":\"http://www.999000.cn/data/files/class_poster/1543202471201811261121116591.jpg\",\"name\":\"裤子\",\"children\":null},{\"id\":2372,\"pid\":2365,\"photo\":\"http://www.999000.cn/data/files/class_poster/1543202494201811261121349888.jpg\",\"name\":\"茄克/风衣\",\"children\":null},{\"id\":2373,\"pid\":2365,\"photo\":\"http://www.999000.cn/data/files/class_poster/1543202527201811261122079429.jpg\",\"name\":\"西服/马甲\",\"children\":null},{\"id\":2374,\"pid\":2365,\"photo\":\"http://www.999000.cn/data/files/class_poster/1543202544201811261122245886.jpg\",\"name\":\"卫衣\",\"children\":null},{\"id\":2376,\"pid\":2365,\"photo\":\"http://www.999000.cn/data/files/class_poster/1543202615201811261123352484.jpg\",\"name\":\"衬衫/长袖\",\"children\":null},{\"id\":7333,\"pid\":2365,\"photo\":\"http://www.999000.cn/data/files/class_poster/1576027985201912110933058605.jpg\",\"name\":\"皮毛服装\",\"children\":null}]},{\"id\":2377,\"pid\":2311,\"photo\":\"http://www.999000.cn/data/files/class_poster/1543051150201811241719107047.jpg\",\"name\":\"春夏\",\"children\":[{\"id\":2378,\"pid\":2377,\"photo\":\"http://www.999000.cn/data/files/class_poster/1543202655201811261124156970.jpg\",\"name\":\"T恤\",\"children\":null},{\"id\":2379,\"pid\":2377,\"photo\":\"http://www.999000.cn/data/files/class_poster/1543212992201811261416327866.jpg\",\"name\":\"裙装\",\"children\":null},{\"id\":2380,\"pid\":2377,\"photo\":\"http://www.999000.cn/data/files/class_poster/1543213005201811261416452299.jpg\",\"name\":\"裤子\",\"children\":null},{\"id\":2400,\"pid\":2377,\"photo\":\"http://www.999000.cn/data/files/class_poster/1543213029201811261417097361.jpg\",\"name\":\"外套\",\"children\":null},{\"id\":2416,\"pid\":2377,\"photo\":\"http://www.999000.cn/data/files/class_poster/1553745693201903281201333732.jpg\",\"name\":\"衬衫\",\"children\":null},{\"id\":2419,\"pid\":2377,\"photo\":\"http://www.999000.cn/data/files/class_poster/1556597500201904301211406970.jpg\",\"name\":\"褶之风尚\",\"children\":null}]}]},{\"id\":2402,\"pid\":0,\"photo\":\"http://shop.mall.345678.com.cn//public/uploads/15e8321e362392086e5eea44d79273e8.png\",\"name\":\"厨房小家电\",\"children\":[{\"id\":2455,\"pid\":2402,\"photo\":\"http://www.999000.cn/data/files/class_poster/1568620288201909161551286110.jpg\",\"name\":\"厨具\",\"children\":[{\"id\":2424,\"pid\":2455,\"photo\":\"http://www.999000.cn/data/files/class_poster/1561691482201906281111226049.jpg\",\"name\":\"刀具套装\",\"children\":null},{\"id\":2426,\"pid\":2455,\"photo\":\"http://www.999000.cn/data/files/class_poster/1561691427201906281110275776.jpg\",\"name\":\"炒锅\",\"children\":null},{\"id\":2429,\"pid\":2455,\"photo\":\"http://www.999000.cn/data/files/class_poster/1561701998201906281406383377.jpg\",\"name\":\"餐具\",\"children\":null},{\"id\":2430,\"pid\":2455,\"photo\":\"http://www.999000.cn/data/files/class_poster/1561702007201906281406476492.jpg\",\"name\":\"锅具套装\",\"children\":null}]},{\"id\":2456,\"pid\":2402,\"photo\":\"http://www.999000.cn/data/files/class_poster/1568620885201909161601258245.jpg\",\"name\":\"小家电\",\"children\":[{\"id\":2403,\"pid\":2456,\"photo\":\"http://www.999000.cn/data/files/class_poster/1544777136201812141645362052.jpg\",\"name\":\"炖锅\",\"children\":null},{\"id\":2404,\"pid\":2456,\"photo\":\"http://www.999000.cn/data/files/class_poster/1544777155201812141645555834.jpg\",\"name\":\"咖啡机\",\"children\":null},{\"id\":2405,\"pid\":2456,\"photo\":\"http://www.999000.cn/data/files/class_poster/1544777170201812141646101196.jpg\",\"name\":\"搅拌机\",\"children\":null},{\"id\":2406,\"pid\":2456,\"photo\":\"http://www.999000.cn/data/files/class_poster/1544777370201812141649308192.jpg\",\"name\":\"破壁机\",\"children\":null},{\"id\":2407,\"pid\":2456,\"photo\":\"http://www.999000.cn/data/files/class_poster/1544777199201812141646393000.jpg\",\"name\":\"烤盘\",\"children\":null},{\"id\":2408,\"pid\":2456,\"photo\":\"http://www.999000.cn/data/files/class_poster/1545097145201812180939058834.jpg\",\"name\":\"电饭煲\",\"children\":null},{\"id\":2427,\"pid\":2456,\"photo\":\"http://www.999000.cn/data/files/class_poster/1561701977201906281406176163.jpg\",\"name\":\"消毒柜\",\"children\":null},{\"id\":2436,\"pid\":2456,\"photo\":\"http://www.999000.cn/data/files/class_poster/1565166386201908071626267221.jpg\",\"name\":\"热水壶\",\"children\":null},{\"id\":2449,\"pid\":2456,\"photo\":\"http://www.999000.cn/data/files/class_poster/1568620999201909161603199439.jpg\",\"name\":\"电烤箱\",\"children\":null},{\"id\":2458,\"pid\":2456,\"photo\":\"http://shop.mall.345678.com.cn/public/uploads/48406cded9140b544dc3f17c9b4210dd.jpg\",\"name\":\"足浴盆\",\"children\":null},{\"id\":7336,\"pid\":2456,\"photo\":\"http://www.999000.cn/data/files/class_poster/1588644928202005051015283366.png\",\"name\":\"吸尘器\",\"children\":null},{\"id\":7337,\"pid\":2456,\"photo\":\"http://shop.mall.345678.com.cn/public/uploads/6dc649350994bb758ed89c17065858c5.jpg\",\"name\":\"挂烫机\",\"children\":null}]}]},{\"id\":2410,\"pid\":0,\"photo\":\"http://shop.mall.345678.com.cn//public/uploads/10de57ab7c8d2c544dd7290ca98e83da.png\",\"name\":\"食品\",\"children\":[{\"id\":2450,\"pid\":2410,\"photo\":\"http://www.999000.cn/data/files/class_poster/1566372216201908211523369581.jpg\",\"name\":\"酒水饮料\",\"children\":null}]},{\"id\":2417,\"pid\":0,\"photo\":\"http://shop.mall.345678.com.cn//public/uploads/05decfa7cd2a76480306b60620250217.png\",\"name\":\"会员套餐\",\"children\":null},{\"id\":2451,\"pid\":0,\"photo\":\"http://shop.mall.345678.com.cn//public/uploads/5e264658d8c7c209232cb85b5d9351ba.png\",\"name\":\"潮流鞋靴\",\"children\":[{\"id\":7334,\"pid\":2451,\"photo\":\"http://www.999000.cn/data/files/class_poster/1577326593201912261016332710.jpg\",\"name\":\"WQ-II\",\"children\":null}]},{\"id\":2460,\"pid\":0,\"photo\":\"http://www.999000.cn/data/files/class_poster/1570757085201910110924451215.jpg\",\"name\":\"品牌专区\",\"children\":[{\"id\":2754,\"pid\":2460,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"手机通讯\",\"children\":[{\"id\":2755,\"pid\":2754,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"手机\",\"children\":null},{\"id\":2764,\"pid\":2754,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"手机配件\",\"children\":null}]},{\"id\":3893,\"pid\":2460,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"家用电器\",\"children\":[{\"id\":3894,\"pid\":3893,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"大 家 电\",\"children\":null},{\"id\":3904,\"pid\":3893,\"photo\":\"http://shop.mall.345678.com.cn//public/uploads/bd553b12e0ce0f92b7371e2646ec0bc3.png\",\"name\":\"厨卫大电\",\"children\":null},{\"id\":3916,\"pid\":3893,\"photo\":\"http://shop.mall.345678.com.cn//public/uploads/3cb5f4c577b8a009d20aa6ad134d26cc.png\",\"name\":\"厨房小电\",\"children\":null},{\"id\":3945,\"pid\":3893,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"生活电器\",\"children\":null},{\"id\":3963,\"pid\":3893,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"个护健康\",\"children\":null},{\"id\":4026,\"pid\":3893,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"家电配件\",\"children\":null},{\"id\":4035,\"pid\":3893,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"视听影音\",\"children\":null}]},{\"id\":4279,\"pid\":2460,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"数码\",\"children\":[{\"id\":4280,\"pid\":4279,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"摄影摄像\",\"children\":null},{\"id\":4292,\"pid\":4279,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"数码配件\",\"children\":null},{\"id\":4304,\"pid\":4279,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"智能设备\",\"children\":null},{\"id\":4316,\"pid\":4279,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"影音娱乐\",\"children\":null},{\"id\":4325,\"pid\":4279,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"电子教育\",\"children\":null}]},{\"id\":4339,\"pid\":2460,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"电脑、办公\",\"children\":[{\"id\":4340,\"pid\":4339,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"电脑整机\",\"children\":null},{\"id\":4349,\"pid\":4339,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"电脑组件\",\"children\":null},{\"id\":4366,\"pid\":4339,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"外设产品\",\"children\":null},{\"id\":4382,\"pid\":4339,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"游戏设备\",\"children\":null},{\"id\":4388,\"pid\":4339,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"网络产品\",\"children\":null},{\"id\":4396,\"pid\":4339,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"办公设备\",\"children\":null},{\"id\":4414,\"pid\":4339,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"文具\",\"children\":null},{\"id\":4437,\"pid\":4339,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"办公耗材\",\"children\":null}]},{\"id\":4517,\"pid\":2460,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"家居日用\",\"children\":[{\"id\":4518,\"pid\":4517,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"收纳用品\",\"children\":null},{\"id\":4524,\"pid\":4517,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"生活日用\",\"children\":null},{\"id\":4531,\"pid\":4517,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"家装软饰\",\"children\":null}]},{\"id\":4544,\"pid\":2460,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"家纺\",\"children\":[{\"id\":4545,\"pid\":4544,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"床上用品\",\"children\":null},{\"id\":4577,\"pid\":4544,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"居家布艺\",\"children\":null}]},{\"id\":4591,\"pid\":2460,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"服饰内衣\",\"children\":[{\"id\":4655,\"pid\":4591,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"内衣\",\"children\":null},{\"id\":4679,\"pid\":4591,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"服饰配件\",\"children\":null}]},{\"id\":4725,\"pid\":2460,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"美妆护肤\",\"children\":[{\"id\":4726,\"pid\":4725,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"男士面部护肤\",\"children\":null},{\"id\":4740,\"pid\":4725,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"美妆工具\",\"children\":null},{\"id\":4751,\"pid\":4725,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"面部护肤\",\"children\":null},{\"id\":4766,\"pid\":4725,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"香水彩妆\",\"children\":null}]},{\"id\":4836,\"pid\":2460,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"运动户外\",\"children\":[{\"id\":4837,\"pid\":4836,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"运动鞋包\",\"children\":null},{\"id\":4848,\"pid\":4836,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"运动服饰\",\"children\":null},{\"id\":4861,\"pid\":4836,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"棋牌麻将\",\"children\":null},{\"id\":4880,\"pid\":4836,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"轮滑滑板\",\"children\":null},{\"id\":4891,\"pid\":4836,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"骑行运动\",\"children\":null},{\"id\":4905,\"pid\":4836,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"垂钓用品\",\"children\":null},{\"id\":4939,\"pid\":4836,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"运动护具\",\"children\":null},{\"id\":4958,\"pid\":4836,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"瑜伽舞蹈\",\"children\":null},{\"id\":5070,\"pid\":4836,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"户外装备\",\"children\":null},{\"id\":5089,\"pid\":4836,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"健身训练\",\"children\":null},{\"id\":5111,\"pid\":4836,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"体育用品\",\"children\":null}]},{\"id\":5237,\"pid\":2460,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"汽车用品\",\"children\":[{\"id\":5238,\"pid\":5237,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"维修保养\",\"children\":null},{\"id\":5288,\"pid\":5237,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"车载电器\",\"children\":null},{\"id\":5315,\"pid\":5237,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"美容清洗\",\"children\":null},{\"id\":5339,\"pid\":5237,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"汽车装饰\",\"children\":null},{\"id\":5394,\"pid\":5237,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"安全自驾\",\"children\":null}]},{\"id\":5453,\"pid\":2460,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"母婴\",\"children\":[{\"id\":5454,\"pid\":5453,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"奶粉\",\"children\":null},{\"id\":5457,\"pid\":5453,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"营养辅食\",\"children\":null},{\"id\":5466,\"pid\":5453,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"尿裤湿巾\",\"children\":null},{\"id\":5472,\"pid\":5453,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"喂养用品\",\"children\":null},{\"id\":5482,\"pid\":5453,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"洗护用品\",\"children\":null},{\"id\":5493,\"pid\":5453,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"童车童床\",\"children\":null},{\"id\":5504,\"pid\":5453,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"婴童寝居\",\"children\":null},{\"id\":5520,\"pid\":5453,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"妈妈专区\",\"children\":null},{\"id\":5555,\"pid\":5453,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"安全座椅\",\"children\":null}]},{\"id\":5573,\"pid\":2460,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"食品饮料\",\"children\":[{\"id\":5574,\"pid\":5573,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"进口食品\",\"children\":null},{\"id\":5597,\"pid\":5573,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"休闲食品\",\"children\":null},{\"id\":5606,\"pid\":5573,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"粮油调味\",\"children\":null},{\"id\":5616,\"pid\":5573,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"饮料冲调\",\"children\":null},{\"id\":5628,\"pid\":5573,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"茗茶\",\"children\":null}]},{\"id\":5757,\"pid\":2460,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"钟表\",\"children\":[{\"id\":5758,\"pid\":5757,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"腕表\",\"children\":null}]},{\"id\":5773,\"pid\":2460,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"珠宝首饰\",\"children\":[{\"id\":5774,\"pid\":5773,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"时尚饰品\",\"children\":null},{\"id\":5791,\"pid\":5773,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"黄金\",\"children\":null},{\"id\":5805,\"pid\":5773,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"金银投资\",\"children\":null},{\"id\":5817,\"pid\":5773,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"钻石\",\"children\":null},{\"id\":5823,\"pid\":5773,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"翡翠\",\"children\":null},{\"id\":5829,\"pid\":5773,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"水晶玛瑙\",\"children\":null},{\"id\":5845,\"pid\":5773,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"和田玉\",\"children\":null},{\"id\":5852,\"pid\":5773,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"铂金\",\"children\":null},{\"id\":5864,\"pid\":5773,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"木手串/把件\",\"children\":null}]},{\"id\":5884,\"pid\":2460,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"厨具\",\"children\":[{\"id\":5885,\"pid\":5884,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"烹饪锅具\",\"children\":null},{\"id\":5896,\"pid\":5884,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"刀剪菜板\",\"children\":null},{\"id\":5903,\"pid\":5884,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"厨房配件\",\"children\":null},{\"id\":5912,\"pid\":5884,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"水具酒具\",\"children\":null},{\"id\":5923,\"pid\":5884,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"餐具\",\"children\":null},{\"id\":5935,\"pid\":5884,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"茶具\",\"children\":null},{\"id\":5945,\"pid\":5884,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"咖啡具\",\"children\":null}]},{\"id\":6838,\"pid\":2460,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"酒类\",\"children\":[{\"id\":6839,\"pid\":6838,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"白酒\",\"children\":null},{\"id\":6841,\"pid\":6838,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"葡萄酒\",\"children\":null},{\"id\":6843,\"pid\":6838,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"洋酒\",\"children\":null}]},{\"id\":6887,\"pid\":2460,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"家庭清洁/纸品\",\"children\":[{\"id\":6888,\"pid\":6887,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"清洁纸品\",\"children\":null},{\"id\":6896,\"pid\":6887,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"清洁用具\",\"children\":null},{\"id\":6906,\"pid\":6887,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"衣物清洁\",\"children\":null},{\"id\":6913,\"pid\":6887,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"家庭环境清洁\",\"children\":null},{\"id\":6922,\"pid\":6887,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"驱蚊驱虫\",\"children\":null},{\"id\":6925,\"pid\":6887,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"皮具护理\",\"children\":null}]},{\"id\":6937,\"pid\":2460,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"个人护理\",\"children\":[{\"id\":6938,\"pid\":6937,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"洗发护发\",\"children\":null},{\"id\":6946,\"pid\":6937,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"美发假发/造型\",\"children\":null},{\"id\":6962,\"pid\":6937,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"身体护理\",\"children\":null},{\"id\":6985,\"pid\":6937,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"女性护理\",\"children\":null},{\"id\":6992,\"pid\":6937,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"口腔护理\",\"children\":null}]}]},{\"id\":7305,\"pid\":0,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"特品专区\",\"children\":[{\"id\":7317,\"pid\":7305,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"百货\",\"children\":null},{\"id\":7328,\"pid\":7305,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"新品推荐\",\"children\":null},{\"id\":7330,\"pid\":7305,\"photo\":\"http://www.999000.cn/data/system/ic_launcher.png\",\"name\":\"厨具\",\"children\":null}]}]"
        val gson = Gson()

        val type = object : TypeToken<MutableList<ClassifyBean>>() {}.type
        val result = gson.fromJson<MutableList<ClassifyBean>>(jsonStr, type)

        result[0].isChecked = true

        result.forEach {
            if (it.children == null || it.children!!.size == 0) {
                val tempBean =
                    ClassifyBean(it.id, it.name, it.photo, it.pid, mutableListOf(), false)
                it.children = mutableListOf(tempBean)
            }
        }

        return@withContext result
    }

    suspend fun getGoodsList(page: Int): MutableList<ListItemBean> = withContext(Dispatchers.IO) {
        val jsonStr =
            "{\"list\":[{\"proid\":\"263\",\"proname\":\"fox男士单肩包斜挎包 男式蓝色斜挎包A086909175004\",\"marketprice\":\"2499.00\",\"vipprice\":\"750.00\",\"shop_type\":\"2\",\"img\":\"http://www.999000.cn/data/files/store_2/goods_128/small_201703151708488426.jpg\",\"lf\":\"599.00\"},{\"proid\":\"381\",\"proname\":\"FOX菲可斯时尚百搭斜挎包男士单肩包A086909171004\",\"marketprice\":\"2499.00\",\"vipprice\":\"750.00\",\"shop_type\":\"2\",\"img\":\"http://www.999000.cn/data/files/store_2/goods_43/small_1506741043201709301110435798.jpg\",\"lf\":\"599.00\"},{\"proid\":\"1244\",\"proname\":\"FOX男士手提包休闲商务百搭大容量手提包A087878087006\",\"marketprice\":\"4528.00\",\"vipprice\":\"1358.00\",\"shop_type\":\"2\",\"img\":\"http://www.999000.cn/data/files/store_2/goods_128/small_1503645328201708251515287249.jpg\",\"lf\":\"1080.00\"},{\"proid\":\"1540\",\"proname\":\"WQii威可 男士商务皮带经典男士自动扣皮带A089935161\",\"marketprice\":\"368.00\",\"vipprice\":\"110.00\",\"shop_type\":\"2\",\"img\":\"http://www.999000.cn/data/files/store_2/goods_170/small_1572941570201911051612505467.jpg\",\"lf\":\"66.00\"},{\"proid\":\"1597\",\"proname\":\"荣事达亚摩斯智能升降火锅6930117001758\",\"marketprice\":\"4560.00\",\"vipprice\":\"1368.00\",\"shop_type\":\"2\",\"img\":\"http://www.999000.cn/data/files/store_2/goods_164/small_1566357564201908211119244128.jpg\",\"lf\":\"821.00\"},{\"proid\":\"1655\",\"proname\":\"WQii威可女士休闲百搭女士时装衫(褶)B306928948\",\"marketprice\":\"2000.00\",\"vipprice\":\"600.00\",\"shop_type\":\"2\",\"img\":\"http://www.999000.cn/data/files/store_2/goods_41/small_201611041730411526.jpg\",\"lf\":\"360.00\"},{\"proid\":\"4469\",\"proname\":\"威可（WQ-ii）真皮皮鞋男式士休闲商务真皮透气软底正装尖头黑色低帮皮鞋男A109969061\",\"marketprice\":\"2999.00\",\"vipprice\":\"900.00\",\"shop_type\":\"2\",\"img\":\"http://www.999000.cn/data/files/store_2/goods_106/small_1576909106201912211418264010.jpg\",\"lf\":\"540.00\"},{\"proid\":\"4517\",\"proname\":\"慕鸿多功能空气炸锅 SW-A1SW-A1\",\"marketprice\":\"2499.00\",\"vipprice\":\"750.00\",\"shop_type\":\"2\",\"img\":\"http://www.999000.cn/data/files/store_2/goods_165/small_1587975765202004271622455701.jpg\",\"lf\":\"450.00\"},{\"proid\":\"4518\",\"proname\":\"塞姆蜂窝红点钛金微压锅SM-DM-01SM-DM-01\",\"marketprice\":\"1699.00\",\"vipprice\":\"510.00\",\"shop_type\":\"2\",\"img\":\"http://www.999000.cn/data/files/store_2/goods_115/small_1587976715202004271638356887.jpg\",\"lf\":\"306.00\"},{\"proid\":\"5097\",\"proname\":\"亚摩斯脱糖电饭煲AS-FT30AAS-FT30A\",\"marketprice\":\"5520.00\",\"vipprice\":\"1656.00\",\"shop_type\":\"2\",\"img\":\"http://www.999000.cn/data/files/store_2/goods_124/small_1588125924202004291005241426.jpg\",\"lf\":\"994.00\"},{\"proid\":\"5370\",\"proname\":\"威可（WQii）编织正装皮鞋A109969091\",\"marketprice\":\"3299.00\",\"vipprice\":\"990.00\",\"shop_type\":\"2\",\"img\":\"http://www.999000.cn/data/files/store_2/goods_48/small_1578211448202001051604082859.jpg\",\"lf\":\"594.00\"},{\"proid\":\"5379\",\"proname\":\"威可（WQ-ii）牛皮休闲鞋 厚底登山鞋  男鞋透气运动潮鞋休闲鞋男新款韩版潮鞋皮鞋系带驾车鞋子A109969021\",\"marketprice\":\"2999.00\",\"vipprice\":\"900.00\",\"shop_type\":\"2\",\"img\":\"http://www.999000.cn/data/files/store_2/goods_1/small_1578211001202001051556419677.jpg\",\"lf\":\"540.00\"},{\"proid\":\"5382\",\"proname\":\"威可（WQ-ii）牛皮休闲鞋  男鞋透气运动潮鞋休闲鞋男新款韩版潮鞋皮鞋系带驾车鞋子A109969022\",\"marketprice\":\"2999.00\",\"vipprice\":\"900.00\",\"shop_type\":\"2\",\"img\":\"http://www.999000.cn/data/files/store_2/goods_84/small_1578211084202001051558045479.jpg\",\"lf\":\"540.00\"},{\"proid\":\"23369\",\"proname\":\"男表金边皮带简约金盘石英商务手表钟表情侣表金色V0154052310\",\"marketprice\":\"29999.00\",\"vipprice\":\"9000.00\",\"shop_type\":\"2\",\"img\":\"http://www.999000.cn/data/files/store_2/goods_96/small_1576044896201912111414565231.jpg\",\"lf\":\"5400.00\"},{\"proid\":\"24272\",\"proname\":\"纯手工编织威可（WQ-ii）男士手包 头层牛皮钱包多功能软皮商务男卡包手机包 细编织纹A089964023012\",\"marketprice\":\"11368.00\",\"vipprice\":\"3410.00\",\"shop_type\":\"2\",\"img\":\"http://www.999000.cn/data/files/store_2/goods_15/small_1576826015201912201513358323.jpg\",\"lf\":\"2046.00\"},{\"proid\":\"24293\",\"proname\":\"WQii威可女士黑色手包女士提包挎包手提包B089960091009\",\"marketprice\":\"5558.00\",\"vipprice\":\"1667.00\",\"shop_type\":\"2\",\"img\":\"http://www.999000.cn/data/files/store_2/goods_64/small_1588065264202004281714249415.jpg\",\"lf\":\"1000.00\"},{\"proid\":\"24294\",\"proname\":\"WQii威可女士黑色手包女士提包挎包手提包B089960101009\",\"marketprice\":\"4688.00\",\"vipprice\":\"1406.00\",\"shop_type\":\"2\",\"img\":\"http://www.999000.cn/data/files/store_2/goods_102/small_1588065502202004281718223464.jpg\",\"lf\":\"844.00\"},{\"proid\":\"24295\",\"proname\":\"WQii威可女士黑色手包女士提包挎包B089960111009\",\"marketprice\":\"5658.00\",\"vipprice\":\"1697.00\",\"shop_type\":\"2\",\"img\":\"http://www.999000.cn/data/files/store_2/goods_36/small_1588065636202004281720361092.jpg\",\"lf\":\"1018.00\"},{\"proid\":\"24703\",\"proname\":\"女表太阳纹珍珠贝母金边皮带简约石英商务手表钟表情侣表金色V01426143550\",\"marketprice\":\"35999.00\",\"vipprice\":\"10800.00\",\"shop_type\":\"2\",\"img\":\"http://www.999000.cn/data/files/store_2/goods_65/small_1599466065202009071607453780.jpg\",\"lf\":\"6480.00\"},{\"proid\":\"24704\",\"proname\":\"女士手表金边皮带简约金盘石英商务手表钟表情侣表金色表V0153052310\",\"marketprice\":\"25999.00\",\"vipprice\":\"7800.00\",\"shop_type\":\"2\",\"img\":\"http://www.999000.cn/data/files/store_2/goods_162/small_1577771762201912311356028509.jpg\",\"lf\":\"4680.00\"},{\"proid\":\"28022\",\"proname\":\"男表金边皮带简约石英商务手表钟表情侣表金色V0154054310\",\"marketprice\":\"29999.00\",\"vipprice\":\"9000.00\",\"shop_type\":\"2\",\"img\":\"http://www.999000.cn/data/files/store_2/goods_32/small_1599450632202009071150327788.jpg\",\"lf\":\"5400.00\"},{\"proid\":\"37085\",\"proname\":\"威可（WQ-ii） 潮流电脑男士旅行袋手提包旅行袋 A089918051018\",\"marketprice\":\"3288.00\",\"vipprice\":\"986.00\",\"shop_type\":\"2\",\"img\":\"http://www.999000.cn/data/files/store_2/goods_130/small_1598931131202009011132114077.jpg\",\"lf\":\"800.00\"},{\"proid\":\"37132\",\"proname\":\"威可（WQ-ii）男士提包 大容量旅行袋潮流时尚欧美 A089918073018\",\"marketprice\":\"3288.00\",\"vipprice\":\"986.00\",\"shop_type\":\"2\",\"img\":\"http://www.999000.cn/data/files/store_2/goods_58/small_1598946458202009011547389603.jpg\",\"lf\":\"592.00\"},{\"proid\":\"37465\",\"proname\":\"WQII威可冬季新品冬装针织衫男士打底衫保暖衣线衣毛衫圆领潮上衣男装 A300933008\",\"marketprice\":\"1599.00\",\"vipprice\":\"480.00\",\"shop_type\":\"2\",\"img\":\"http://www.999000.cn/data/files/store_2/goods_24/small_1599296624202009051703442254.jpg\",\"lf\":\"288.00\"},{\"proid\":\"37569\",\"proname\":\"WQII威可卫衣男秋冬韩版长袖男时尚卫衣青年百搭休闲上衣服男装 A040933021\",\"marketprice\":\"1299.00\",\"vipprice\":\"390.00\",\"shop_type\":\"2\",\"img\":\"http://www.999000.cn/data/files/store_2/goods_173/small_1599634773202009091459338289.jpg\",\"lf\":\"234.00\"},{\"proid\":\"38941\",\"proname\":\"亨德利项链和田玉轻奢珠宝时尚简约百搭饰品锁骨链平安扣项链+套链 Y20051603\",\"marketprice\":\"5000.00\",\"vipprice\":\"1500.00\",\"shop_type\":\"2\",\"img\":\"http://www.999000.cn/data/files/store_2/goods_84/small_1600672884202009211521241181.jpg\",\"lf\":\"900.00\"},{\"proid\":\"39564\",\"proname\":\"威可（WQ-ii）夹克男拉链外套秋冬男士冬季冬款韩版潮牌上衣男装外衣潮流茄克衫冬天褂子 A400961001\",\"marketprice\":\"2399.00\",\"vipprice\":\"720.00\",\"shop_type\":\"2\",\"img\":\"http://www.999000.cn/data/files/store_2/goods_40/small_1601110840202009261700408086.jpg\",\"lf\":\"432.00\"},{\"proid\":\"39565\",\"proname\":\"威可（WQ-ii）夹克男外套秋冬男士冬季冬款韩版潮牌上衣男装拉链外衣潮流茄克衫冬天褂子 A400961011\",\"marketprice\":\"2399.00\",\"vipprice\":\"720.00\",\"shop_type\":\"2\",\"img\":\"http://www.999000.cn/data/files/store_2/goods_48/small_1601111048202009261704086829.jpg\",\"lf\":\"432.00\"},{\"proid\":\"39566\",\"proname\":\"威可（WQ-ii）夹克男外套秋冬男士冬季冬款韩版潮牌上衣男装拉链外衣潮流茄克衫冬天褂子 A400961021\",\"marketprice\":\"2399.00\",\"vipprice\":\"720.00\",\"shop_type\":\"2\",\"img\":\"http://www.999000.cn/data/files/store_2/goods_179/small_1601111179202009261706194675.jpg\",\"lf\":\"432.00\"},{\"proid\":\"41079\",\"proname\":\"威可（WQ-ii）长袖衬衫男秋冬季男士舒适休闲衬衣上班百搭简约翻领长袖打底衫 A190924005\",\"marketprice\":\"1799.00\",\"vipprice\":\"540.00\",\"shop_type\":\"2\",\"img\":\"http://www.999000.cn/data/files/store_2/goods_17/small_1603444817202010231720177607.jpg\",\"lf\":\"324.00\"}]}"
        val gson = Gson()
        val bean = gson.fromJson<ListBean>(jsonStr, ListBean::class.java)
        return@withContext bean?.list ?: mutableListOf()
    }

    suspend fun getGoodsDetail(proId: String): DetailBean = withContext(Dispatchers.IO) {
        val result = DetailBean("商品id=${proId}")

        return@withContext result
    }
}