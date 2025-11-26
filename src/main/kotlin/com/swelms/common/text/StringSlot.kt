package com.swelms.common.text


class StringSlots(val text: String, val slotRegex: Regex = Companion.slotRegex) {

   fun replace(vararg values: Any): String {
      val result = StringBuilder(text)
      val matches = slotRegex.findAll(text).toList()
      for (match in matches.asReversed()) {
         val index = match.groupValues[1].toInt() //1 = numero de {numero}
         val value = values.getOrNull(index-indexSlice)?.toString() ?: continue
         result.replace(match.range.first, match.range.last + 1, value)
      }
      return result.toString()
   }


   override fun toString(): String = text

   companion object{
      var slotRegex = "\\{(\\d+)}".toRegex()
      var indexSlice = 1
   }

}

operator fun String.invoke(vararg values: Any): String = StringSlots(this).replace(values = values)
