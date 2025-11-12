package com.sbarrasa.person

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlin.test.*


class NameAsStringSerializerTest {
   @Serializable
   data class Wrapper(val name: Name)

   private val json = Json { encodeDefaults = true }

   @Test
   fun serializeToString() {
      val name = Name("Barrasa Rabinovich, Sebastian Gabriel")
      val encoded = json.encodeToString(name)
      assertEquals("\"Barrasa Rabinovich, Sebastian Gabriel\"", encoded)
   }

   @Test
   fun deserializeFromString() {
      val decoded = json.decodeFromString<Name>("\"Barrasa Rabinovich, Sebastian Gabriel\"")
      assertEquals("Sebastian Gabriel", decoded.names)
      assertEquals("Barrasa Rabinovich", decoded.lastNames)
   }

   @Test
   fun serializeInsideObject() {
      val wrapper = Wrapper(Name("Barrasa Rabinovich, Sebastian Gabriel"))
      val encoded = json.encodeToString(wrapper)
      assertEquals("{\"name\":\"Barrasa Rabinovich, Sebastian Gabriel\"}", encoded)
   }

   @Test
   fun deserializeInsideObject() {
      val jsonStr = "{\"name\":\"Barrasa Rabinovich, Sebastian Gabriel\"}"
      val decoded = json.decodeFromString<Wrapper>(jsonStr)
      assertEquals("Sebastian Gabriel", decoded.name.names)
      assertEquals("Barrasa Rabinovich", decoded.name.lastNames)
   }
}
