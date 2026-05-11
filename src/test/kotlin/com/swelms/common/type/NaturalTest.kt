package com.swelms.common.type

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails


class NaturalTest {
   @Test
   fun create() {
      assertFails { Natural(-1) }
      assertEquals(10, Natural(10).value)
   }

}