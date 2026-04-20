package com.swelms.common.math

@JvmInline
value class Natural(val value: Int){
    init {
        require(value >= 0)
    }
    operator fun component1() = value
    companion object {
        fun sequence(start: Int = 1): Sequence<Natural> =
            generateSequence(start) { it + 1 }
                .map(::Natural)
    }
}