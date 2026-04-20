package com.swelms.common.math

open class Real<T: Number>(n: T) : Num<T>(
    n,
    constraint = { it::class in types }
) {
    companion object {
        val types = setOf(Double::class, Float::class)
    }
}