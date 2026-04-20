package com.swelms.common.math

class Integer(n: Number) : Num<Long>(
    n.toLong(),
    constraint = { it::class in types }
) {
    companion object {
        val types = setOf(Int::class, Long::class, Short::class, Byte::class)
    }
}