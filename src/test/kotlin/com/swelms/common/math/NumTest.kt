package com.swelms.common.math

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails

class NumTest {
    @Test
    fun fromInt() {
        val a = Num(3)
        assertEquals(3, a.value)
    }

    @Test
    fun fromDouble() {
        val a = Num(3.0)
        assertEquals(3.0, a.value)
    }

    @Test
    fun constrained() {
        val a = Num(0) { it >= 0 }
        a.value = 2

        assertEquals(2, a.value)

        assertFails { a.value = -1 }
    }

    @Test
    fun plus() {
        val a = Num(3)
        val b = a + 1
        val c = a + 1.5 + 2L + 3f
        assertEquals(3, a.value)
        assertEquals(4, b.value)
        assertEquals(9, c.value)
    }

    @Test
    fun plusDouble() {
        val a = Num(3.0)
        val b = a + 1.5 + 1
        assertEquals(5.5, b.value)
    }

    @Test
    fun propagateConstraints() {
        val a = Num(3) { it > 0 }
        val b = a + 1.5
        assertFails { b.value = -1 }
    }

    @Test
    fun operationFail() {
        val a = Num(3) { it > 0 }
        assertFails { a - 10 }
    }

    @Test
    fun destructure() {
        val (v) = Num(3)
        assertEquals(3, v)
    }

    @Test
    fun fail() {
        assertFails { Num(-1) { it > 0 } }
    }

    @Test
    fun toLong(){
        val a = Num(300000)
        val b = a.toLong()
        assertEquals(300000L, b)
    }


}