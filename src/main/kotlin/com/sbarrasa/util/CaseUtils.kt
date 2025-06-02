package com.sbarrasa.util

import kotlin.reflect.KClass


enum class CaseType {
   LOWER, UPPER, CAMEL, SNAKE, PASCAL
}

fun String.toCase(caseType: CaseType?): String = when (caseType) {
   CaseType.LOWER -> lowercase()
   CaseType.UPPER -> uppercase()
   CaseType.CAMEL -> toCamelCase()
   CaseType.SNAKE -> toSnakeCase()
   CaseType.PASCAL -> toPascalCase()
   else -> this
}

fun String.toCamelCase(): String =
   split('_')
      .mapIndexed { i, part ->
         if (i == 0) part.lowercase()
         else part.replaceFirstChar { it.uppercaseChar() }
      }
      .joinToString("")

fun String.toPascalCase(): String =
   split('_')
      .joinToString("") { it.replaceFirstChar { c -> c.uppercaseChar() } }

fun String.toSnakeCase(): String =
   replace(Regex("([a-z])([A-Z])"), "$1_$2")
      .replace(Regex("([A-Z])([A-Z][a-z])"), "$1_$2")
      .lowercase()

fun KClass<*>.simpleName(caseType: CaseType?): String =
   simpleName!!.toCase(caseType)

