package com.swelms.common.collections

fun <T> MutableList<T>.swap(i: Int, j: Int) {
    require(i in indices && j in indices)
    if (i == j) return
    val tmp = this[i]
    this[i] = this[j]
    this[j] = tmp
}