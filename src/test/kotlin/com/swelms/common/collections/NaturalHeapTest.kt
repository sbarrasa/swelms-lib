package com.swelms.common.collections

import kotlin.test.Test
import kotlin.test.assertEquals


class NaturalHeapTest {
    @Test
    fun pop() {
        val h = naturalHeap(listOf('b', 'c', 'a'))
        assertEquals('a', h.pop())
    }

    @Test
    fun pop1() {
        val h = naturalHeap<Char>().apply {
            push('b')
            push('c')
            push('a')
        }
        assertEquals('a', h.pop())
    }
}