package com.swelms.common.math

class Combinator<T>(private val items: List<T>) {

   fun combinations(k: Int = 2): Set<List<T>> = combinations(items, k, 0, emptyList())

   fun permutations(k: Int = 2): Set<List<T>> = permutations(items, k, emptyList())

   fun variations(k: Int = 2): Set<List<T>> = variations(items, k, emptyList(), mutableSetOf())

   private fun <T> combinations(list: List<T>, k: Int, start: Int, acc: List<T>, result: MutableSet<List<T>> = mutableSetOf()): Set<List<T>> {
      if (acc.size == k) { result.add(acc); return result }
      for (i in start until list.size) combinations(list, k, i + 1, acc + list[i], result)
      return result
   }

   private fun <T> permutations(list: List<T>, k: Int, acc: List<T>, result: MutableSet<List<T>> = mutableSetOf()): Set<List<T>> {
      if (acc.size == k) { result.add(acc); return result }
      for ((_, item) in list.withIndex()) permutations(list - item, k, acc + item, result)
      return result
   }

   private fun <T> variations(list: List<T>, k: Int, acc: List<T>, result: MutableSet<List<T>>): Set<List<T>> {
      if (acc.size == k) { result.add(acc); return result }
      for (item in list) variations(list, k, acc + item, result)
      return result
   }
}

fun <T> Iterable<T>.combinations(k: Int = 2) = Combinator(this.toList()).combinations(k)
fun <T> Iterable<T>.permutations(k: Int = 2) = Combinator(this.toList()).permutations(k)
fun <T> Iterable<T>.variations(k: Int = 2) = Combinator(this.toList()).variations(k)
