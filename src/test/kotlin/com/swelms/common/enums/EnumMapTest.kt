package com.swelms.common.enums

import com.swelms.common.collections.keyClass
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class EnumMapTest {
   enum class MyEnum(val description: String) {
      A("Alpha"),
      B("Beta"),
      C("Gamma")
   }


   @Test
   fun createFromAssociate(){
      val map = MyEnum.entries.associateWith { it.description }
      assertTrue(map is EnumMap)
      assertEquals(MyEnum::class, map.keyClass)
    }

   @Test
   fun createWithFactory(){
      val map = enumMap(MyEnum::description)
      assertTrue { map is EnumMap }
      assertEquals(MyEnum::class, map.keyClass)
   }

   @Test
   fun create(){
      val map = EnumMap(MyEnum.entries.associateWith { it.description })
      assertTrue { map is EnumMap }
      assertEquals(MyEnum::class, map.keyClass)

   }

}