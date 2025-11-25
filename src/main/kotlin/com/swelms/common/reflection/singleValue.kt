package com.swelms.common.reflection

import kotlin.reflect.KProperty1
import kotlin.reflect.KVisibility
import kotlin.reflect.full.memberProperties
import kotlin.reflect.full.primaryConstructor

@Suppress("UNCHECKED_CAST")
val Any?.singleValue: Any?
   get() {
      if (this == null) return null
      val primary = this::class.primaryConstructor ?: return null
      if (primary.parameters.size != 1) return null
      val param = primary.parameters.first()
      val prop = this::class.memberProperties
         .firstOrNull { it.name == param.name && it.visibility == KVisibility.PUBLIC } ?: return null
      return (prop as KProperty1<Any, Any?>).get(this)
   }


val Any?.isSingleValue: Boolean
   get() = singleValue != null

val Any?.asSingleValue: Any?
   get() = singleValue ?: this
