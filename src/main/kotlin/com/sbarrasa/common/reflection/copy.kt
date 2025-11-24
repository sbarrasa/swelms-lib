package com.sbarrasa.common.reflection

import kotlin.collections.iterator
import kotlin.reflect.KMutableProperty1
import kotlin.reflect.full.memberProperties

inline fun <reified S : Any, reified T : Any> copy(source: S, target: T, ignoreNulls: Boolean = true) {
   val sProps = S::class.memberProperties.associateBy { it.name }
   val tProps = T::class.memberProperties
      .filterIsInstance<KMutableProperty1<T, Any?>>()
      .associateBy { it.name }

   for ((name, sProp) in sProps) {
      val tProp = tProps[name] ?: continue
      val value = sProp.get(source)
      val internalValue = getInternalValue(value)

      if (ignoreNulls && internalValue == null) continue

      tProp.set(target, value)
   }
}

inline fun <reified S : Any, reified T : Any> S.copyTo(target: T, ignoreNulls: Boolean = true): T {
   copy(this, target, ignoreNulls)
   return target
}

