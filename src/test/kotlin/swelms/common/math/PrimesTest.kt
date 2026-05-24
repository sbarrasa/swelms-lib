package swelms.common.math

import kotlin.test.Test
import kotlin.test.assertEquals


class PrimesTest {
   @Test
   fun takeFirst(){
      val first = primes().first()
      assertEquals(2, first)
   }

   @Test
   fun take5(){
      val primes = primes()
      val first5 = primes.take(5).toList()
      assertEquals(listOf(2L, 3L, 5L, 7L, 11L), first5)
   }

   @Test
   fun nth5(){
      val number = primes().nth(5)
      assertEquals(11, number)
   }


}