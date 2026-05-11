package com.swelms.common.type

import kotlin.test.Test
import kotlin.test.assertFails

class RestrictedTest {
   @Test
   fun create() {
      val a = 10
      assertFails { Restricted(a) {a > 10} }

   }

}