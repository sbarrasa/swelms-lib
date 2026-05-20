package com.swelms.common.mapper

import kotlin.reflect.KClass

inline fun <T : Any, reified U : Any> createFrom(source: T): U {
   return createFrom(source, U::class)
}

fun <T : Any, U : Any> createFrom(source: T, targetClass: KClass<U>): U {
   val propsMap = compareProperties(source::class, targetClass)
      .associate { it.second.name to it.first.getter.call(source) }

   return createFromMap(propsMap, targetClass)
}