package com.swelms.common.bool

data class BoolMap<out T>(val trueValue: T, val falseValue: T) {
    operator fun get(value: Boolean): T = if (value) trueValue else falseValue
    operator fun invoke(block: () -> Boolean): T = get(block())
}

infix fun <T> T.orElse(falseValue: T) = BoolMap(this, falseValue)

fun <T, A:T, B:T> Pair<A, B>.toBoolMap() = BoolMap(this.first, this.second)
