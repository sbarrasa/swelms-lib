package com.swelms.common.collections

import kotlin.test.*


class EnumMapTest {
   enum class MyEnum(val description: String) {
      A("Alpha"),
      B("Beta"),
      C("Gamma")
   }


   @Test
   fun enumMapCreate(){
      val map = EnumMap(MyEnum.entries) { it.description }
      assertTrue { map is EnumMap }
      assertEquals("Alpha", map[MyEnum.A])
      assertEquals("Beta", map[MyEnum.B])
      assertEquals(MyEnum::class, map.enumClass)
   }

   @Test
   fun enumMapCreate2(){
      val map = EnumMap(MyEnum.entries.associateWith { it.description })
      assertTrue { map is EnumMap }
      assertEquals("Alpha", map[MyEnum.A])
      assertEquals("Gamma", map[MyEnum.C])
      assertEquals(MyEnum::class, map.enumClass)
   }

   @Test
   fun createFromAssociate(){
      val map = MyEnum.entries.associateWith { it.description }
      assertTrue { map is EnumMap }
      assertEquals(MyEnum::class, map.enumClass)
    }

}