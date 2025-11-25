package com.swelms.domain.person

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

object NamePartSerializer : KSerializer<NamePart> {
   override val descriptor: SerialDescriptor =
      PrimitiveSerialDescriptor("Names", PrimitiveKind.STRING)

   override fun serialize(encoder: Encoder, value: NamePart) {
      encoder.encodeString(value.text)
   }

   override fun deserialize(decoder: Decoder): NamePart {
      return NamePart(decoder.decodeString())
   }
}

