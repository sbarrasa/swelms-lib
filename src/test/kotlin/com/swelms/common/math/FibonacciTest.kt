package com.swelms.common.math

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


class FibonacciTest {
    @Test
    fun list() {
        val result = fibonacci().take(8).toList()
        val expected = listOf(0, 1, 1, 2, 3, 5, 8, 13).map(Int::toLong)
        assertEquals(expected, result)

    }

    @Test
    fun elementAt(){
        assertEquals(0, fibonacci().elementAt(0))
        assertEquals(13, fibonacci().elementAt(7))
    }

}