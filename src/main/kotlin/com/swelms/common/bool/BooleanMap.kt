package com.swelms.common.bool

data class BooleanMap<T>(val trueValue: T, val falseValue: T) {
    fun get(value: Boolean) = if (value) trueValue else falseValue
}

fun <T> Boolean.map(trueValue: T, falseValue: T)
    = BooleanMap(trueValue, falseValue).get(this)

