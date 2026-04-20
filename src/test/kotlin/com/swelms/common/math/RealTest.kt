package com.swelms.common.math

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails


class RealTest {
    @Test
    fun fromDouble(){
        val n = Real(0.0)
        assertEquals(0.0, n.value)
    }

    @Test
    fun fromFloat(){
        val n = Real(0.0f)
        assertEquals(0.0f, n.value)
    }

    @Test
    fun fromInt(){
        assertFails { Real(1)}
    }
}