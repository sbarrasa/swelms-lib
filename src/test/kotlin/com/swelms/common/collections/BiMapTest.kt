package com.swelms.common.collections

import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test
import kotlin.test.assertFails


class BiMapTest {
    @Test
    fun of(){
        val map1 = mapOf('a' to 1, 'b' to 2, 'c' to 3)
        val map2 = biMapOf('a' to 1, 'b' to 2, 'c' to 3)
        val map3 = biMapOf(map1)
        val map4 = map1.toBiMap()

        assertEquals('b', map2.getKey(2))
        assertEquals('b', map3.getKey(2))
        assertEquals('b', map4.getKey(2))

    }

    @Test
    fun get(){
        val map = biMapOf('a' to 1, 'b' to 2, 'c' to 3)

        assertEquals(2, map['b'])
        assertEquals('c', map.getKey(3))

    }

    @Test
    fun invalid(){
        assertFails { biMapOf('a' to 1, 'b' to 2, 'c' to 1) }
    }

    @Test
    fun inverse(){
        val map = biMapOf('a' to 1, 'b' to 2, 'c' to 3)
        val inverse = map.inverse
        assertEquals(3, map['c'])
        assertEquals('c', inverse[3])
    }

}