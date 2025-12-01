package com.swelms.domain.person.name

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

open class FullNameSerializer: KSerializer<FullName> {

   override val descriptor: SerialDescriptor =
      PrimitiveSerialDescriptor("FullName", PrimitiveKind.STRING)

   override fun serialize(encoder: Encoder, value: FullName) {
      encoder.encodeString(FullName.Formatter.legalOrder(value))
   }

   override fun deserialize(decoder: Decoder): FullName {
      val fullText = decoder.decodeString()
      return FullName(fullText)
   }

}