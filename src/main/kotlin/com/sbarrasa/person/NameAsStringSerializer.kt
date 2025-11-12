package com.sbarrasa.person

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

object NameAsStringSerializer : KSerializer<Name> {
   override val descriptor = PrimitiveSerialDescriptor("Name", PrimitiveKind.STRING)

   override fun serialize(encoder: Encoder, value: Name) {
      encoder.encodeString(value.legalNameFormat())
   }

   override fun deserialize(decoder: Decoder): Name {
      return Name(decoder.decodeString())
   }
}
