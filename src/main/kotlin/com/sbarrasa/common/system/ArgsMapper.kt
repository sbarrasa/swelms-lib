package com.sbarrasa.common.system


class ArgsMapper(
   val args: Array<String>,
   val prefix: String = DEFAULT_PREFIX,
   val separator: String = DEFAULT_SEPARATOR
)  {

   operator fun get(key: String) = asMap[key]
   val asMap get() = args
      .mapNotNull {
         val parts = it.split(separator, limit = 2)
         if ((parts.size == 2) && parts[0].startsWith(prefix))
            parts[0].removePrefix(prefix) to parts[1]
         else
            null
      }
      .toMap()

   companion object {
      const val DEFAULT_PREFIX = "-"
      const val DEFAULT_SEPARATOR = "="
   }

}


val Array<String>.asMap get() = asMap()

fun Array<String>.asMap(
   prefix: String = ArgsMapper.DEFAULT_PREFIX,
   separator: String = ArgsMapper.DEFAULT_SEPARATOR
): Map<String, String> {
   return ArgsMapper(this, prefix, separator).asMap
}

operator fun Array<String>.get(key: String): String? {
   return asMap[key]
}
