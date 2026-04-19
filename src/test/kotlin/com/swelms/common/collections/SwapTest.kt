package com.swelms.common.collections

import kotlin.test.Test
import kotlin.test.assertEquals


class SwapTest {
    @Test
    fun swap() {
        val list = mutableListOf('a', 'b', 'c')
        list.swap(0, 1)

        assertEquals(listOf('b', 'a', 'c'), list)

    }

}