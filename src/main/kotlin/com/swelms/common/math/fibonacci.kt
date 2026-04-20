package com.swelms.common.math

fun fibonacci() = generateSequence(0L to 1L) {
    (a, b) -> b to (a + b)
    }.map { it.first }
