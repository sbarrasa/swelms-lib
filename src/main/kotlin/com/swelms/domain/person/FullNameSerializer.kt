package com.swelms.domain.person

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

//TODO: armar un serializador básico y 3 más
// para el nombre completo
// para legalName
// para objeto de dos componentes
object FullNameSerializer : KSerializer<FullName> {
   override val descriptor: SerialDescriptor =
      PrimitiveSerialDescriptor("FullName", PrimitiveKind.STRING)

   override fun serialize(encoder: Encoder, value: FullName) {
      encoder.encodeString(value.text)
   }

   override fun deserialize(decoder: Decoder): FullName {
      return FullName(decoder.decodeString())
   }
}

