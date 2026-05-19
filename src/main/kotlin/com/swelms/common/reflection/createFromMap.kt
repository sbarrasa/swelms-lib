package com.swelms.common.reflection

import kotlin.collections.get
import kotlin.reflect.KClass
import kotlin.reflect.full.primaryConstructor

fun <T: Any>createFromMap(type: KClass<T>, map: Map<String, Any?>): T? {
   val ctor = type.primaryConstructor ?: return null
   val args = ctor.parameters.associateWith { map[it.name] }
   return ctor.callBy(args)
}

inline fun <reified T: Any> createFromMap(map: Map<String, Any?>): T? = createFromMap(T::class, map)

