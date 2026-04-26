package com.swelms.common.pair

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class PairTest {

    @Test
    fun pairElementByBoolean() {
       val charPair = 'T' to 'F'
       assertEquals('T', charPair[true] )
    }

    @Test
    fun pairElementByIndex() {
        val charPair = 'T' to 'F'
        assertEquals('T', charPair[1])
        assertEquals('F', charPair[2])
        assertFailsWith<IndexOutOfBoundsException> { charPair[-1] }
    }





}