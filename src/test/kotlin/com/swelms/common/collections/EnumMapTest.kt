package com.swelms.common.collections

import kotlin.test.*


class EnumMapTest {
   enum class EnumTest(val desc: String) { A("Alpha"), B("Beta"), C("Gamma") }

   @Test
   fun associateTo() {
      val map = EnumTest.entries.associateTo { it.desc }
      assertTrue { map is EnumMap }
      assertEquals("Alpha", map[EnumTest.A])
      assertEquals("Beta", map[EnumTest.B])
      assertEquals(EnumTest::class, map.enumClass)
   }

   @Test
   fun enumMapCreate(){
      val map = EnumMap(EnumTest::desc)
      assertTrue { map is EnumMap }
      assertEquals("Alpha", map[EnumTest.A])
      assertEquals("Beta", map[EnumTest.B])
      assertEquals(EnumTest::class, map.enumClass)
   }

   @Test
   fun enumMapCreate2(){
      val map = EnumMap<EnumTest, String> {it.desc}
      assertTrue { map is EnumMap }
      assertEquals("Alpha", map[EnumTest.A])
      assertEquals("Beta", map[EnumTest.B])
      assertEquals(EnumTest::class, map.enumClass)
   }


}