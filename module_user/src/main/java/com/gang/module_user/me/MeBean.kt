package com.gang.module_user.me

//data class MeBean()

data class MeInfoBean(
    val UserId: String,
    val AvatarUrl: String,
    val Nickname: String,
    val userType: String,
    val invitecode: String
)

data class MeAccountBean(
    val Umoney: String,
    val Pv: String,
    val repeat_money: String
)

data class MeExtendBean(
    val id: Int,
    val name: String
)