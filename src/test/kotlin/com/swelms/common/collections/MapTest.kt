package com.swelms.common.collections

import kotlin.test.*

class MapTest {
   @Test
   fun putPair(){
      val map = mutableMapOf<String, String>()
      map["Hola"] = "Hello"
      map.put("Chau" to "Goodbye")
      assertEquals(2, map.size)
      assertEquals("Hello", map["Hola"])
      assertEquals("Goodbye", map["Chau"])
   }
}