package com.swelms.common.bool

data class BoolMap<T>(val first: T, val second: T)

infix fun <T> T.or(that: T) = BoolMap(this, that)

operator fun <T> BoolMap<T>.get(value: Boolean) = if (value) this.first else this.second

