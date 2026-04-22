package com.swelms.common.collections

import kotlin.collections.component1
import kotlin.collections.component2
import kotlin.collections.iterator
import kotlin.collections.set

fun <K,V> invertMapOf(map: Map<K,V>): Map<V,K>{
    val temp = HashMap<V, K>(map.size)

    for ((k, v) in map) {
        require(!temp.containsKey(v)) {
            "Value: $v is duplicated"
        }
        temp[v] = k
    }

    return temp
}

fun <K,V > Map<K,V>.invert() = invertMapOf(this)