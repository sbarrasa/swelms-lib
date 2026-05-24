package swelms.common.math

import kotlin.test.Test
import kotlin.test.assertEquals


class DivisibilityTest {
   @Test
   fun gcd1(){
      assertEquals(2, gcd(6,4))
   }

   @Test
   fun gcd2(){
      assertEquals(1, gcd(5,3))
   }

   @Test
   fun lcm1(){
      assertEquals(12, lcm(6,4))
   }

   @Test
   fun lcm2(){
      assertEquals(6, lcm(6,2))
   }

}