package com.swelms.common.pair


operator fun <T> Pair<T,T>.get(value: Boolean) = if (value) this.first else this.second

operator fun <T> Pair<T,T>.get(value: Int) = when (value) {
    1 -> this.first
    2 -> this.second
    else -> throw IndexOutOfBoundsException("Pair has 2 values")
}

