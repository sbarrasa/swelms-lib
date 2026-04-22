package com.swelms.common.collections

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import kotlin.test.Test
import kotlin.test.assertFails

class InvertMapOfTest {
    @Test
    fun inverse(){
        val map = mapOf('a' to 1, 'b' to 2, 'c' to 3)
        val inverse = map.invert()
        assertEquals(3, map['c'])
        assertEquals('c', inverse[3])
    }

    @Test
    fun invalid(){
        val map = mapOf('a' to 1, 'b' to 2, 'c' to 2)
        val e = assertFails { map.invert() }
        assertTrue(e is IllegalArgumentException)
    }

}