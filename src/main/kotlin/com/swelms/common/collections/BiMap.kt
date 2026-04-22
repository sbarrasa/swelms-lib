package com.swelms.common.collections


class BiMap<K, V>(
    private val map: Map<K, V>
) : Map<K, V> by map {

    val inverse: Map<V, K> = invertMapOf(map)

    fun getKey(value: V): K? = inverse[value]

}

fun <K, V> biMapOf(map: Map<K, V>): BiMap<K, V> =
    BiMap(map)

fun <K, V> biMapOf(vararg pairs: Pair<K, V>): BiMap<K, V> =
    BiMap(mapOf(*pairs))

fun <K, V> Map<K, V>.toBiMap(): BiMap<K, V> =
    BiMap(this)