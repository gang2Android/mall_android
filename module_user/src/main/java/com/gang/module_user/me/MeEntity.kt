package com.gang.module_user.me

class MeEntity {
    companion object {
        const val ITEM_TOP = 0
        const val ITEM_ACCOUNT = 1
        const val ITEM_ORDER = 2
        const val ITEM_EXTEND = 3
    }

    var itemType = ITEM_TOP

    var spanSize = 2

    var meTopBean: MeInfoBean? = null
    var meAccountBean: MeAccountBean? = null

    var meExtends: MutableList<MeExtendBean>? = null

    override fun toString(): String {
        return "MeEntity(itemType=$itemType, spanSize=$spanSize, meTopBean=$meTopBean, meAccountBean=$meAccountBean, meExtends=$meExtends)"
    }

}