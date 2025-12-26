package com.swelms.common.collections

import com.swelms.common.enums.EnumMap
import com.swelms.common.enums.associateWith
import com.swelms.common.enums.enumMap
import kotlin.test.*


class EnumMapTest {
   enum class MyEnum(val description: String) {
      A("Alpha"),
      B("Beta"),
      C("Gamma")
   }


   @Test
   fun createFromAssociate(){
      val map = MyEnum.entries.associateWith { it.description }
      assertTrue { map is EnumMap }
      assertEquals(MyEnum::class, map.enumClass)
    }

   @Test
   fun createWithFactory(){
      val map = enumMap(MyEnum::description)
      assertTrue { map is EnumMap }
      assertEquals(MyEnum::class, map.enumClass)
   }

   @Test
   fun create(){
      val map = EnumMap(MyEnum.entries.associateWith { it.description })
      assertTrue { map is EnumMap }
      assertEquals(MyEnum::class, map.enumClass)

   }

}