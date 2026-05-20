package com.swelms.common.mapper

import kotlin.collections.get
import kotlin.reflect.KClass
import kotlin.reflect.full.primaryConstructor

fun <T: Any>createFromMap(map: Map<String, Any?>, targetClass: KClass<T>, ): T{
   val ctor = targetClass.primaryConstructor
      ?: throw InstantiationException("Target class ${targetClass.simpleName} must have a primary constructor")

   val args = ctor.parameters
      .filter { map.containsKey(it.name) }
      .associateWith { map[it.name] }

   return ctor.callBy(args)
}

inline fun <reified T: Any> createFromMap(map: Map<String, Any?>) = createFromMap(map, T::class)

