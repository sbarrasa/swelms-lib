package com.swelms.common.math

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails


class NaturalTest {
    @Test
    fun component() {
        val (value) = Natural(10)
        assertEquals(10, value)
    }

    @Test
    fun valueOk() {
        assertEquals(10,Natural(10).value)
    }

    @Test
    fun valueErr(){
        assertFails { Natural(-1)}
    }

    @Test
    fun sequence() {
        val list = Natural.sequence().take(5).toList()
        assertEquals(listOf(1,2,3,4,5).map(::Natural ), list)
    }

    @Test
    fun sequence0Based() {
        val list = Natural.sequence(0).take(5).toList()
        assertEquals(listOf(0,1, 2,3,4).map(::Natural ), list)
    }

}