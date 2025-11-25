package com.swelms.domain.person

import kotlinx.serialization.*
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class NamePartSerializationTest {
   @Serializable
   data class FichaPersona(
      @Serializable(with = NamePartSerializer::class) val apellidos: NamePart,
      @Serializable(with = NamePartSerializer::class) val nombres: NamePart
   )

   @Test
   fun serializaComponentesSeparados() {
      val ficha = FichaPersona(NamePart("Barrasa Rabinovich"), NamePart("Sebastián Gabriel"))
      val jsonGenerado = Json.encodeToString(ficha)

      assertEquals("""{"apellidos":"Barrasa Rabinovich","nombres":"Sebastián Gabriel"}""", jsonGenerado)
   }
}