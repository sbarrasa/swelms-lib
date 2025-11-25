package com.swelms.common.collections

fun <T, K, V> Iterable<T>.associateIf(
   predicate: (T) -> Boolean,
   association: (T) -> Pair<K, V>
): Map<K, V> {
   val result = mutableMapOf<K, V>()
   for (item in this) {
      if (predicate(item)) {
         val (k, v) = association(item)
         result[k] = v
      }
   }
   return result
}

fun <T, K, V> Iterable<T>.associateIfNotNull(
   association: (T) -> Pair<K, V>?
): Map<K, V> =
   associateIf({ association(it) != null }) { association(it)!! }
