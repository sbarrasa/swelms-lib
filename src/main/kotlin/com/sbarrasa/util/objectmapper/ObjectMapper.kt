package com.sbarrasa.util.objectmapper

import kotlin.collections.iterator
import kotlin.reflect.KMutableProperty1
import kotlin.reflect.full.memberProperties

inline fun <reified S : Any, reified T : Any> map(source: S, target: T) {
   val sProps = S::class.memberProperties.associateBy { it.name }
   val tProps = T::class.memberProperties.filterIsInstance<KMutableProperty1<T, Any?>>().associateBy { it.name }

   for ((name, sProp) in sProps) {
      val tProp = tProps[name] ?: continue
      val value = sProp.get(source)
      if (value != null) tProp.set(target, value)
   }
}

inline fun <reified S : Any, reified T : Any> S.mapTo(target: T): T {
   map(this, target)
   return target
}

