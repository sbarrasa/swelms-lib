package com.swelms.common.enums

import kotlin.test.*


class EnumSetTest {
   enum class MyEnum {A, B, C, D, E}

   @Test
   fun createByElements(){
      val set = EnumSet(MyEnum.A, MyEnum.C, MyEnum.E)
      assertTrue(MyEnum.A in set)
      assertFalse(MyEnum.B in set)
   }

   @Test
   fun createByRange(){
      val set = EnumSet(MyEnum.A..MyEnum.C)
      assertTrue(MyEnum.B in set)
      assertFalse(MyEnum.E in set)
   }

   @Test
   fun associateWithIsEnumMap(){
      val map = EnumSet(MyEnum.A..MyEnum.C).associateWith { it.name }
      assertTrue(map is EnumMap)
   }

}