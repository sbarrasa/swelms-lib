package com.swelms.domain.person

import com.swelms.domain.name.FullName
import com.swelms.domain.name.FullNameSerializer
import kotlinx.serialization.*
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class FullNameSerializationTest {
   @Serializable
   data class User(
      @Serializable(with = FullNameSerializer::class)
      val nombres: FullName,
      val rol: String
   )

   @Test
   fun serializaComoStringUnico() {
      val usuario = User(FullName("Barrasa Rabinovich", "Sebastián Gabriel"), "Admin")
      val json = Json.encodeToString(usuario)
       assertEquals("""{"nombres":"Barrasa Rabinovich, Sebastián Gabriel","rol":"Admin"}""".trimIndent(), json)
   }
}