package com.sbarrasa.common.reflection

import kotlin.reflect.full.memberProperties
import kotlin.reflect.full.primaryConstructor
import kotlin.reflect.jvm.isAccessible


fun <T : Any> getInternalValue(value: T?): Any? {
   if (value == null) return null
   val kclass = value::class
   val constructor = kclass.primaryConstructor ?: return value
   if (constructor.parameters.size != 1) return value
   val paramName = constructor.parameters.first().name ?: return value
   val prop = kclass.memberProperties.firstOrNull { it.name == paramName } ?: return value
   prop.isAccessible = true
   return prop.call(value)
}


