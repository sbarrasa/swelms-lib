package com.swelms.common.mapper

import kotlin.reflect.KMutableProperty1

fun copyProperties(source: Any, target: Any) {
   val matchingProperties = compareProperties(source::class, target::class)

   for (pair in matchingProperties) {
      val sourceProp = pair.first
      val targetProp = pair.second

      if (targetProp is KMutableProperty1) {
         val value = sourceProp.getter.call(source)

         @Suppress("UNCHECKED_CAST")
         val mutableTargetProp = targetProp as KMutableProperty1<Any, Any?>
         mutableTargetProp.set(target, value)
      }
   }
}


fun Any.copyTo(target: Any) = copyProperties(this, target)
