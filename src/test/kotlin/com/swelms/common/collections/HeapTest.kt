package com.swelms.common.collections

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class HeapTest {

    @Test
    fun pushPop() {
        val h = Heap<Char>{ a, b -> a.compareTo(b) }

        with(h) {
            push('d')
            push('a')
            push('c')
        }

        assertEquals('a', h.pop())
        assertEquals('c', h.pop())
        assertEquals('d', h.pop())
        assertTrue(h.isEmpty())
    }

    @Test
    fun heapify() {
        val h = Heap(listOf('d', 'a', 'c', 'b')){ a, b -> a.compareTo(b) }

        assertEquals('a', h.pop())
        assertEquals('b', h.pop())
        assertEquals('c', h.pop())
        assertEquals('d', h.pop())
    }

    @Test
    fun peek() {
        val h = Heap<Char>{ a, b -> a.compareTo(b) }

        with(h) {
            push('c')
            push('a')
            push('b')
        }

        assertEquals('a', h.peek)
        assertEquals(3, h.size)
    }

    @Test
    fun empty() {
        val h = Heap<Char>{ a, b -> a.compareTo(b) }

        assertEquals(null, h.pop())
        assertTrue(h.isEmpty())
    }

    @Test
    fun mix() {
        val h = Heap<Char>{ a, b -> a.compareTo(b) }

        with(h) {
            push('c')
            push('a')
        }

        assertEquals('a', h.pop())

        with(h) {
            push('b')
            push('d')
        }

        assertEquals('b', h.pop())
        assertEquals('c', h.pop())
        assertEquals('d', h.pop())
    }
}