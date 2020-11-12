package com.gang.module_goods.classify

data class ClassifyBean(
    val id: String,
    val name: String,
    val photo: String,
    val pid: String,
    var children: MutableList<ClassifyBean>?,

    var isChecked: Boolean
)