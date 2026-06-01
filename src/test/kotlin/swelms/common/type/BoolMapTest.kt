package swelms.common.type

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class BoolMapTest {
   @Test
   fun constructor() {
      val boolMap = BoolMap(1, -1)
      assertEquals(1, boolMap[true])
      assertEquals(-1, boolMap[false])
   }

   @Test
   fun elementByBoolean() {
      val boolMap = 'T' orElse 'F'
      val value = boolMap[true]
      assertEquals('T', value)
   }

   @Test
   fun differentTypeElements() {
      val boolMap = 1 orElse "false"
      assertTrue { boolMap[true] is Int }
      assertTrue { boolMap[false] is String }
      assertEquals(1, boolMap[true])
   }

   @Test
   fun boolCondition() {
      val boolMap = 'T' orElse 'F'
      val a = 1
      val b = 2
      val value = boolMap { a < b }
      assertEquals('T', value)
   }

   @Test
   fun formPair() {
      val pair = 'T' to 'F'
      val boolMap = pair.toBoolMap()

      assertEquals('T', boolMap[true])
   }

   @Test
   fun toPair(){
      val boolMap = 'T' orElse 'F'
      val pair = boolMap.toPair()
      assertEquals('T', pair.first)
      assertEquals('F', pair.second)
   }


   @Test
   fun fromNullable() {
      val boolMap = BoolMap(1, null)
      assertEquals(1, boolMap[true])
      assertEquals(null, boolMap[false])
      assertTrue { boolMap[false] is Nothing? }
   }

   @Test
   fun not(){
      val a = "T" orElse "F"
      val b = !a
      assertEquals("F", b[true])
   }

   @Test
   fun toEither() {
      val a = BoolMap("SI", "NO")
      val b = a.toEither(true)
      assertTrue { b is Either.Right }
   }

}