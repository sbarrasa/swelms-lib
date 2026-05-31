package swelms.common.collections

import swelms.common.locale.Locale
import swelms.common.text.*
import kotlin.reflect.KClass

open class Catalog(val style: Style?) : LinkedHashMap<String, StringMap>() {

   fun put(key: String, value: Map<*,*>): StringMap? {
      val efectiveKey = if (style == null) key else key.applyStyle(style)

      return super.put(efectiveKey, value.toStringMap())
   }

   fun put(clazz: KClass<*>, map:Map<*, *>): StringMap? {
      val className = clazz.simpleName
      requireNotNull(className) { Locale.text("NO_CLASS_NAME") }
      return put(className, map)
   }

   fun put(map: Map<*, *>): StringMap? = put(map.keyClass!!, map)

}

