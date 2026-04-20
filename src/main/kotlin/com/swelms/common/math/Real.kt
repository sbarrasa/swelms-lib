package com.swelms.common.math

class Real(n: Number) : Num<Double>(
    n.toDouble(),
    constraint = { it::class in types }
) {
    companion object {
        val types = setOf(Double::class, Float::class)
    }
}