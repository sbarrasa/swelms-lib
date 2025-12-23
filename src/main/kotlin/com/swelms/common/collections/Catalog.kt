package com.swelms.common.collections

import com.swelms.common.locale.localeText
import com.swelms.common.text.Style
import com.swelms.common.text.toStyle
import kotlin.reflect.KClass

open class Catalog(val style: Style?) : LinkedHashMap<String, StringMap>() {

   private fun applyCase(key: String) = style?.let { key.toStyle(it) } ?: key

   override fun put(key: String, value: StringMap) = super.put(applyCase(key), value)

   fun put(clazz: KClass<*>, map:Map<*, *>): StringMap? {
      val className = clazz.simpleName
      requireNotNull(className) { localeText("NO_CLASS_NAME") }
      return put(className, map.toStringMap())
   }

}

