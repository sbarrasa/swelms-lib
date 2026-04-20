package com.swelms.common.math

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails


class IntegerTest {


    @Test
    fun fromInt(){
        val n = Integer(2)
        assertEquals(2, n.value)
    }

    @Test
    fun fromDouble(){
        assertFails { Integer(0.0)}
    }
}