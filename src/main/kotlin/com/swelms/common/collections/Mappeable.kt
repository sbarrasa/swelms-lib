package com.swelms.common.collections

interface Mappeable<K,T> {
   fun asMap(): Map<K, T>
}

fun Catalog.put(map: EnumMap<*,*>) = put(map.enumClass, map)