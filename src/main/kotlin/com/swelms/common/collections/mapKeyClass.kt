package com.swelms.common.collections

val <K, V> Map<K, V>.keyClass
   get() = keys.firstOrNull()?.let { it::class }