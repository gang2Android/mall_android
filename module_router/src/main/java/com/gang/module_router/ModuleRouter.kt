package com.gang.module_router

object ModuleRouter {
    const val MAIN_SPLASH = "/main/splash"
    const val MAIN_ADVERT = "/main/advert"
    const val MAIN_GUIDE = "/main/guide"
    const val MAIN_INDEX = "/main/index"

    const val HOME_INDEX_ACTIVITY = "/home/index"
    const val HOME_INDEX = "/home/fragment"

    const val GOODS_CLASSIFY = "/goods/classify"

    const val CART_INDEX = "/cart/index"

    const val USER_ME = "/user/me"

    const val USER_LOGIN = "/user/login"
    const val USER_LOGIN_ACTIVITY = "/user/login/activity"

    const val USER_REG = "/user/reg"
    const val USER_REG_ACTIVITY = "/user/reg/activity"

    const val USER_SHARE = "/user/share"
    const val USER_SHARE_ACT = "/user/share/activity"

    const val USER_SET = "/user/set"
    const val USER_SET_ACT = "/user/set/activity"

    const val USER_PWD = "/user/pwd"
    const val USER_PWD_ACT = "/user/pwd/activity"

    const val USER_ADDRESS_LIST = "/user/address/list"
    const val USER_ADDRESS_LIST_ACTIVITY = "/user/address/list/activity"
    const val USER_ADDRESS_DET = "/user/address/det"
    const val USER_ADDRESS_DET_ACTIVITY = "/user/address/det/activity"

    const val ORDER_LIST = "/order/list"
    const val ORDER_LIST_ACT = "/order/list/act"
    const val ORDER_DET = "/order/det"
    const val ORDER_DET_ACT = "/order/det/act"
    const val ORDER_AFFIRM = "/order/affirm"
    const val ORDER_AFFIRM_ACT = "/order/affirm/act"
    const val ORDER_PAY = "/order/pay"
    const val ORDER_PAY_ACT = "/order/pay/act"

    object User {
        object Account {
            const val FRAGMENT = "/user/account"
            const val ACTIVITY = "/user/account/activity"

            object Transfer {
                const val FRAGMENT = "/user/account/transfer"
                const val ACTIVITY = "/user/account/transfer/activity"
            }
        }
    }

}