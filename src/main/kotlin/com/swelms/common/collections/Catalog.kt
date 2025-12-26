package com.swelms.common.collections

import com.swelms.common.locale.localeText
import com.swelms.common.text.*
import kotlin.reflect.KClass

open class Catalog(val style: Style?) : LinkedHashMap<String, StringMap>() {

   fun put(key: String, value: Map<*,*>) = super.put(key.applyStyle(style), value.toStringMap())

   fun put(clazz: KClass<*>, map:Map<*, *>): StringMap? {
      val className = clazz.simpleName
      requireNotNull(className) { localeText("NO_CLASS_NAME") }
      return put(className, map)
   }

   fun put(map: Map<*, *>): StringMap? = put(map.keyClass!!, map)

}

