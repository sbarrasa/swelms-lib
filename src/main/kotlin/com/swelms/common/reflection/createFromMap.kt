package com.swelms.common.reflection

import kotlin.reflect.KClass
import kotlin.reflect.full.primaryConstructor

fun <T: Any>create(type: KClass<T>, map: Map<String, Any?>): T? {
   val ctor = type.primaryConstructor ?: return null
   val args = ctor.parameters.associateWith { map[it.name] }
   return ctor.callBy(args)
}

inline fun <reified T: Any> createFromMap(map: Map<String, Any?>): T? = create(T::class, map)


fun KClass<out Any>.createFromMap(map: Map<String, Any?>) = create(this, map)
