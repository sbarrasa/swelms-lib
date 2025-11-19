package com.sbarrasa.domain.person

object NameUtils {
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

   object msg {
      var LAST_NAMES = "Apellidos"
      var NAMES = "Nombres"
      var INVAlID_FORMAT = "Formato invalido. Debe ser: $LAST_NAMES, $NAMES"
   }
}