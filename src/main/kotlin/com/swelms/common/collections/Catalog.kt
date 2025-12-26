package com.swelms.common.collections

import com.swelms.common.locale.localeText
import com.swelms.common.text.*
import kotlin.reflect.KClass

open class Catalog(val style: Style?) : LinkedHashMap<String, StringMap>() {

   override fun put(key: String, value: StringMap) = super.put(key.applyStyle(style), value)

   fun put(clazz: KClass<*>, map:Map<*, *>): StringMap? {
      val className = clazz.simpleName
      requireNotNull(className) { localeText("NO_CLASS_NAME") }
      return put(className, map.toStringMap())
   }

   fun put(map: Map<*, *>): StringMap? = put(map.keyClass!!, map)

}

