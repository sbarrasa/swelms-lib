package swelms.common.type

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class BoolMapTest {
   @Test
   fun constructor() {
      val map = BoolMap(1, -1)
      assertEquals(1, map[true])
      assertEquals(-1, map[false])
   }

   @Test
   fun elementByBoolean() {
      val map = 'T' orElse 'F'
      val value = map[true]
      assertEquals('T', value)
   }

   @Test
   fun differentTypeElements() {
      val map = 1 orElse "false"
      assertTrue { map[true] is Int }
      assertTrue { map[false] is String }
      assertEquals(1, map[true])
   }

   @Test
   fun boolCondition() {
      val map = 'T' orElse 'F'
      val a = 1
      val b = 2
      val value = map { a < b }
      assertEquals('T', value)
   }

   @Test
   fun formPair() {
      val pair = 'T' to 'F'
      val map = pair.toBoolMap()

      assertEquals('T', map[true])
   }

   @Test
   fun toPair(){
      val map = 'T' orElse 'F'
      val pair = map.toPair()
      assertEquals('T', pair.first)
      assertEquals('F', pair.second)
   }


   @Test
   fun fromNullable() {
      val map = BoolMap(1, null)
      assertEquals(1, map[true])
      assertEquals(null, map[false])
      assertTrue { map[false] is Nothing? }
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