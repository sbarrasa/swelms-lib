package com.swelms.common.collections

import kotlin.test.Test
import kotlin.test.assertEquals

class StringMapTest {
    @Test
    fun toStringMap() {
        val original = mapOf("a" to 1, 2 to "b", true to 3.0)
        val stringMap = original.toStringMap()
        
        assertEquals("1", stringMap["a"])
        assertEquals("b", stringMap["2"])
        assertEquals("3.0", stringMap["true"])
        assertEquals(3, stringMap.size)
    }
}
