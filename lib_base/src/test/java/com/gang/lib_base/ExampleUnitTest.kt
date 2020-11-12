package com.gang.lib_base

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
//        assertEquals(4, 2 + 2)
        println(NumArithUtils.add("90.100", "99.00"))
        println(NumArithUtils.sub("90.100", "99.00"))
        println(NumArithUtils.mul("90.100", "99.00"))
        println(NumArithUtils.div("10.100", "3"))
    }
}