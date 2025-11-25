package com.swelms.domain.person

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

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
