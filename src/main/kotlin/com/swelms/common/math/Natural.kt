package com.swelms.common.math

class Natural(value: Number): Num<Long>(value.toLong()) {

    companion object {
        fun sequence(start: Int = 1): Sequence<Natural> {
            require(start in 0..1)
            return generateSequence(start) { it + 1 }
                .map(::Natural)
        }
    }
}