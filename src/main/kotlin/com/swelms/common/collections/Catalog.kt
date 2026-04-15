package com.swelms.common.collections

import com.swelms.common.locale.localeText
import com.swelms.common.text.*
import kotlin.reflect.KClass

open class Catalog(val style: Style?) : LinkedHashMap<String, StringMap>() {

   fun put(key: String, value: Map<*,*>): StringMap? {
      val efectiveKey = if (style == null)
         key
      else
         key.applyStyle(style)

      return super.put(efectiveKey, value.toStringMap())
   }

   fun put(clazz: KClass<*>, map:Map<*, *>): StringMap? {
      val className = clazz.simpleName
      requireNotNull(className) { localeText("NO_CLASS_NAME") }
      return put(className, map)
   }

   fun put(map: Map<*, *>): StringMap? = put(map.keyClass!!, map)

}

