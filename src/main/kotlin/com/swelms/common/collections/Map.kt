package com.swelms.common.collections

fun <K, V> MutableMap<K, V>.put(pair: Pair<K, V>) {
   this[pair.first] = pair.second
}

fun Catalog.put(map: Map<*, *>): StringMap? = put(map::class, map)
