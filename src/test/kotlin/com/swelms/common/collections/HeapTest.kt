package com.swelms.common.collections

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class HeapTest {

    @Test
    fun pushPop() {
        val h = naturalHeap<Char>()

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
        val h = naturalHeap(listOf('d', 'a', 'c', 'b'))

        assertEquals('a', h.pop())
        assertEquals('b', h.pop())
        assertEquals('c', h.pop())
        assertEquals('d', h.pop())
    }

    @Test
    fun peek() {
        val h = naturalHeap<Char>()

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
        val h = naturalHeap<Char>()

        assertEquals(null, h.pop())
        assertTrue(h.isEmpty())
    }

    @Test
    fun mix() {
        val h = naturalHeap<Char>()

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

   @Test
   fun heapOfData(){
      data class Person(val name: String, val age: Int)
      val person1 = Person("John", 32)
      val person2 = Person("Maria",40)
      val person3 = Person("Pepe",18)

      val heap = Heap(listOf(person1, person2, person3)) { a, b ->
         a.age.compareTo(b.age)
      }

      assertEquals(person3, heap.pop())
      assertEquals(person1, heap.pop())

   }

}