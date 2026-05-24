package swelms.common.type

import kotlin.test.Test
import kotlin.test.assertEquals


class LazyBoolMapTest {
   @Test
   fun orElse() {
      var count = 0

      val map = {
         count = 1
         "T"
      } orElse {
         count = -1
         "F"
      }
      assertEquals(0, count)
      assertEquals("T", map[true])
      assertEquals(1, count)
      assertEquals("F", map[false])
      assertEquals(-1, count)

   }


   @Test
   fun inv() {
      var count = 0

      val map = {
         count = 1
         "T"
      } orElse {
         count = -1
         "F"
      }

      val invMap = !map
      assertEquals(0, count)

      assertEquals("T", invMap[false])
      assertEquals(1, count)
   }

}