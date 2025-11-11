package com.sbarrasa.util.args

import com.sbarrasa.map.Mappeable

class ArgsMapper(
   val args: Array<String>,
   val prefix: String = DEFAULT_PREFIX,
   val separator: String = DEFAULT_SEPARATOR
) : Mappeable<String, String> {


   val asMap = asMap()

   operator fun get(key: String) = asMap[key]

   override fun asMap(): Map<String, String> = args
      .mapNotNull { arg ->
         val parts = arg.split(separator, limit = 2)
         if ((parts.size == 2)
            && parts[0].startsWith(prefix)
         )
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


