package com.swelms.common.math

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails


class NaturalTest {
    @Test
    fun create() {
        val n = Natural(1)
        assertEquals(1, n.value)
    }


    @Test
    fun failFromNegative(){
        assertFails { Natural(-1) }
    }


    @Test
    fun dec(){
        val n = Natural(0)
        assertFails { n.value--}
    }


}