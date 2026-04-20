package com.swelms.common.math

class Integer<T: Number>(n: T) : Num<T>(
    n,
    constraint = { it::class in types }
) {
    companion object {
        val types = setOf(Int::class, Long::class, Short::class, Byte::class)
    }
}