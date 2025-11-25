package com.swelms.domain.person

import kotlinx.serialization.Serializable


@Serializable
@JvmInline
value class NamePart(override val text: String) : Name {
   init {
      NameUtils.validate(text)
   }
}