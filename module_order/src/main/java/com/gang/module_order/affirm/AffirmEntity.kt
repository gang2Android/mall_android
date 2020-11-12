package com.gang.module_order.affirm

class AffirmEntity {
    companion object {
        const val ITEM_ADDRESS = 1
        const val ITEM_SUP_HEADER = 2
        const val ITEM_PRO = 3
        const val ITEM_SUP_BOT = 4
        const val ITEM_BOT = 5
    }

    var itemType = ITEM_ADDRESS

    var addressBean: AffirmAddressBean? = null
    var supBean: AffirmSupBean? = null
    var proBean: AffirmProBean? = null

    var bot: AffirmBean? = null

    override fun toString(): String {
        return "AffirmEntity(itemType=$itemType, addressBean=$addressBean, supBean=$supBean, proBean=$proBean, bot=$bot)"
    }

}