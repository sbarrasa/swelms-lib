package com.swelms.common.text



class StringSlots(val text: String, val slotRegex: Regex = Companion.slotRegex) {

   fun replace(vararg values: Any?): String {
      val result = StringBuilder(text)
      for (match in slots.asReversed()) {
         val index = match.index
         val value = values.getOrNull(index-indexSlice)?.toString() ?: continue
         result.replace(match.range.first, match.range.last + 1, value)
      }

      if (values.size > slots.size) {
         val extra = values.drop(slots.size).joinToString(" ")
         result.append(" ").append(extra)
      }
      return result.toString()
   }

   val slots get() = slotRegex.findAll(text).toList()

   private val MatchResult.index get() = groupValues[1].toInt()

   val minIndex = slots.minOfOrNull { it.index }
   val indexSlice = if (minIndex == 0) 0 else 1
   companion object{
      var slotRegex = "\\{(\\d+)}".toRegex()

   }

   override fun toString(): String = text

}

fun String.replaceSlots(vararg values: Any): String = StringSlots(this).replace(*values)
