package com.swelms.common.math

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class CombinatorTest {

   private val items = listOf("A", "B", "C", "D")

   @Test
   fun testCombinations2() {
      val result = items.combinations(2)
      val expected = setOf(
         listOf("A", "B"), listOf("A", "C"), listOf("A", "D"),
         listOf("B", "C"), listOf("B", "D"), listOf("C", "D")
      )
      assertEquals(expected, result)
   }

   @Test
   fun testCombinations3() {
      val result = items.combinations(3)
      val expected = setOf(
         listOf("A", "B", "C"), listOf("A", "B", "D"),
         listOf("A", "C", "D"), listOf("B", "C", "D")
      )
      assertEquals(expected, result)
   }

   @Test
   fun testPermutations2() {
      val result = items.permutations(2)
      val expected = setOf(
         listOf("A", "B"), listOf("A", "C"), listOf("A", "D"),
         listOf("B", "A"), listOf("B", "C"), listOf("B", "D"),
         listOf("C", "A"), listOf("C", "B"), listOf("C", "D"),
         listOf("D", "A"), listOf("D", "B"), listOf("D", "C")
      )
      assertEquals(12, result.size)
      expected.forEach { assertTrue(it in result) }
   }

   @Test
   fun testVariations2() {
      val result = items.variations(2)
      val expected = mutableSetOf<List<String>>()
      for(a in items) for(b in items) expected.add(listOf(a, b))
      assertEquals(16, result.size)
      expected.forEach { assertTrue(it in result) }
   }

   @Test
   fun testVariations1() {
      val expected = items.map { listOf(it) }.toSet()
      assertEquals(expected, items.variations(1))
   }
}
