package com.gang.lib_base

import java.math.BigDecimal

object NumArithUtils {

    private const val SCALE = 2

    fun add(v1: String, v2: String, scale: Int = SCALE): String {
        val b1 = BigDecimal(v1)
        val b2 = BigDecimal(v2)
        return b1.add(b2).setScale(scale, BigDecimal.ROUND_HALF_UP).toString()
    }

    fun sub(v1: String, v2: String, scale: Int = SCALE): String {
        val b1 = BigDecimal(v1)
        val b2 = BigDecimal(v2)
        return b1.subtract(b2).setScale(scale, BigDecimal.ROUND_HALF_UP).toString()
    }

    fun mul(v1: String, v2: String, scale: Int = SCALE): String {
        val b1 = BigDecimal(v1)
        val b2 = BigDecimal(v2)
        return b1.multiply(b2).setScale(scale, BigDecimal.ROUND_HALF_UP).toString()
    }

    fun div(v1: String, v2: String, scale: Int = SCALE): String {
        val b1 = BigDecimal(v1)
        val b2 = BigDecimal(v2)
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).toString()
    }
}