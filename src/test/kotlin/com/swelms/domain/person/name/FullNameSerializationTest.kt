package com.swelms.domain.person.name

import kotlinx.serialization.*
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class FullNameSerializationTest {
   @Serializable
   data class User(
      @Serializable(with = FullNameSerializer::class)
      val names: FullName,
      val rol: String
   )

   @Test
   fun serializeAsString() {
      val usuario = User(FullName(NamePart("Barrasa Rabinovich"), NamePart("Sebastián Gabriel")), "Admin")
      val json = Json.encodeToString(usuario)
       assertEquals("""{"names":"Barrasa Rabinovich, Sebastián Gabriel","rol":"Admin"}""".trimIndent(), json)
   }
}