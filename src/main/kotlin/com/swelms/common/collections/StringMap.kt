package com.swelms.common.collections

typealias StringMap = Map<String, String>

fun Map<*,*>.toStringMap(): StringMap =
   mapKeys { it.key.toString() }
      .mapValues { it.value.toString() }
