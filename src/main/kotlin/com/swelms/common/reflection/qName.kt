package com.swelms.common.reflection

import kotlin.reflect.KClass

val KClass<*>.qName: String
   get() = qualifiedName
      ?.removeSuffix(".Companion")
      ?: "<unknown>"

val Any.qName: String
   get() = this::class.qName

