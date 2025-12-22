package com.swelms.common.text

import kotlin.text.lowercase

sealed class Case(val joiner: Char? = null) {
   protected var separators = listOf(' ', '-', '_')

   open fun inputSeparators(vararg chars: Char): Case {
      separators = chars.toList()
      return this
   }

   protected fun apply(text: String, mapPart: (Int, String) -> String = { _, s -> s }): String {

      val parts = text.split(*separators.toCharArray()).mapIndexed(mapPart)
      return joiner?.let { parts.joinToString(it.toString()) } ?: parts.joinToString("")
   }

   abstract fun transform(text: String): String

   object LOWER : Case() {
      init { separators = emptyList() }
      override fun transform(text: String) = text.lowercase()
   }

   object UPPER : Case() {
      init { separators = emptyList() }
      override fun transform(text: String) = text.uppercase()
   }

   object CAMEL : Case() {
      override fun transform(text: String) =
         apply(text) { i, s -> if (i == 0) s.lowercase() else s.replaceFirstChar { it.uppercaseChar() } }
   }

   object PASCAL : Case() {
      override fun transform(text: String) =
         apply(text) { _, s -> s.replaceFirstChar { it.uppercaseChar() } }
   }

   object SNAKE : Case('_') {
      override fun transform(text: String) = apply(text) { _, s -> s.lowercase() }
   }

   object KEBAB : Case('-') {
      override fun transform(text: String) = apply(text) { _, s -> s.lowercase() }
   }

   object DOT : Case('.') {
      override fun transform(text: String) = apply(text) { _, s -> s.lowercase() }
   }

   class SEPARATED(joiner: Char? = null) : Case(joiner) {
      override fun transform(text: String) = apply(text)
   }

   val sample = "sample model".toCase(this)
}

fun String.toCase(case: Case): String = case.transform(this)
