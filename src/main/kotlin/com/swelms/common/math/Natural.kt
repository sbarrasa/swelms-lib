package com.swelms.common.math

class Natural(n: Int): Num<Int>(
    n,
    constraint = { it::class in Integer.types
                && it >= 0 }
)