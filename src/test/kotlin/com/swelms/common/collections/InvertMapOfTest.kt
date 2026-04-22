package com.swelms.common.collections

import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class InvertMapOfTest {
    @Test
    fun inverse(){
        val map = mapOf('a' to 1, 'b' to 2, 'c' to 3)
        val inverse = map.invert()
        assertEquals(3, map['c'])
        assertEquals('c', inverse[3])
    }
}