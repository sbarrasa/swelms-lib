package com.swelms.common.text

import kotlin.text.lowercase

enum class Case(val transform: (String) -> String) {
   LOWER({it.lowercase()}),
   UPPER({it.uppercase()}),
   CAMEL({it.camelCase()}),
   SNAKE({it.snakeCase()}),
   UPPER_SNAKE({it.snakeCase().uppercase()}),
   PASCAL({it.pascalCase()});

   val sample get() = "sample model".toCase(this)
}

fun String.toCase(case: Case): String = case.transform(this)

fun String.camelCase(): String =
   split(' ', '_')
      .mapIndexed { i, part ->
         if (i == 0) part.lowercase()
         else part.replaceFirstChar { it.uppercaseChar() }
      }
      .joinToString("")

fun String.pascalCase(): String =
   split(' ', '_')
      .joinToString("") { it.replaceFirstChar { c -> c.uppercaseChar() } }

fun String.snakeCase(): String =
   replace(Regex("([a-z])([A-Z])"), "$1_$2")
      .replace(Regex("([A-Z])([A-Z][a-z])"), "$1_$2")
      .replace(' ' , '_')
      .lowercase()

