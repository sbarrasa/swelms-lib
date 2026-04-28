package com.swelms.common.type

import kotlin.test.Test
import kotlin.test.assertEquals


class RefTest {
   @Test
   fun accumulator() {
      val acc = Ref(0)

      listOf(1, 2, 3).forEach {
         acc.value += it
      }

      assertEquals(6, acc.value)
   }
}