package com.sbarrasa.domain.person

import kotlinx.serialization.Serializable


@Serializable
@JvmInline
value class Name(val value: String): Nombrable {
   init {
      NameUtils.validate(value)
   }

   val parts get() = FullName.from(value, validate = false)

   override val names get() = parts.names

   override val lastNames get() = parts.lastNames


   operator fun plus(other: Name) = FullName(lastNames=value, names = other.value)

   fun legalNameFormat() = value

   fun fullNameFormat() = "$names $lastNames"

   override fun toString() = value

}