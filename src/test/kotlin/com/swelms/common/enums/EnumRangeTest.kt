package com.swelms.common.enums

import kotlin.test.*


class EnumRangeTest {
   enum class MyEnum {A, B, C, D, E}

   @Test
   fun testRange(){
      val range = MyEnum.B..MyEnum.D
      assertTrue(range.contains(MyEnum.D))
      assertFalse(range.contains(MyEnum.E))

   }
}