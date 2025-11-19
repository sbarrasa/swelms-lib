package com.sbarrasa.domain.person

import kotlinx.serialization.Serializable


@Serializable
@JvmInline
value class Name(val value: String): Nombrable {
   init {
      validate(value)
   }

   val parts get() = NameParts.from(value, validate = false)

   override val names get() = parts.names

   override val lastNames get() = parts.lastNames

   val nameList get() = names.split(" ")
   val lastNameList get() = lastNames?.split(" ") ?: emptyList()

   val fullNameList get() = nameList + lastNameList

   val count: Int get() = fullNameList.size

   operator fun get(index: Int) = fullNameList[index]

   operator fun plus(other: Name) = Name("$value, ${other.value}")

   fun legalNameFormat() = value

   fun fullNameFormat() = "$names $lastNames"

   override fun toString() = value

   companion object {
      fun clean(value: String): String {
         val regex = Regex("[\\p{L} ,]")
         val filtered = value.filter { regex.matches(it.toString()) }.trim()
         return filtered.replace(Regex("\\s+"), " ")
      }
      fun validate(value: String) = require(isValid(value)) { msg.INVAlID_FORMAT }

      fun isValid(value: String): Boolean {
         return (value.count { it == ',' } <= 1)
               && (value == clean(value))
      }
   }

   object msg {
      var LAST_NAMES = "Apellidos"
      var NAMES = "Nombres"
      var INVAlID_FORMAT = "Formato invalido. Debe ser: $LAST_NAMES, $NAMES"
   }
}