package com.swelms.common.collections

import com.swelms.common.text.Style
import kotlin.test.*


class CatalogTest {
   enum class MyEnum { A, B, C, D }
   data class User(val id: Int)

   @Test
   fun testPuts() {
      val cat = Catalog(Style.TITLE)
      val enumMap = MyEnum.entries.associateWith { it.ordinal }
      val userMap = mapOf(User(1) to "U1", User(2) to "U2")

      cat.put(enumMap)
      cat.put(User::class, userMap)
      cat["Manual"] = userMap.toStringMap()

      assertTrue(cat.containsKey("Myenum"))
      assertTrue(cat.containsKey("User"))
      assertTrue(cat.containsKey("Manual"))
   }
}