package com.swelms.common.math

open class Num<T : Number>(
    n: T,
    private val constraint: (T) -> Boolean = { true }
) {
    var value: T = n
        set(v) {
            require(constraint(v))
            field = v
        }
    @Suppress("UNCHECKED_CAST")
    private fun c(newValue: Double) = when (value) {
        is Double -> newValue
        is Float -> newValue.toFloat()
        is Int -> newValue.toInt()
        is Long -> newValue.toLong()
        is Short -> newValue.toInt().toShort()
        is Byte -> newValue.toInt().toByte()
        else -> newValue
    } as T


    operator fun plus(other: Number) = Num(c(value.toDouble() + other.toDouble()), constraint)
    operator fun minus(other: Number) = Num(c(value.toDouble() - other.toDouble()), constraint)
    operator fun times(other: Number) = Num(c(value.toDouble() * other.toDouble()), constraint)
    operator fun div(other: Number) = Num(c(value.toDouble() / other.toDouble()), constraint)
    operator fun inc() = plus(1)
    operator fun dec() = minus(1)
}