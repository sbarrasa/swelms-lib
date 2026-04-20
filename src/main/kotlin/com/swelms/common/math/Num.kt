package com.swelms.common.math

import com.swelms.common.validator.Validable

open class Num<T : Number> (
    n: T,
    private val constraint: (T) -> Boolean = { true }
): Number(), Validable<T> {

    override fun validate(value: T): T = value.also {
        if(!constraint(it)) throw ArithmeticException("$value is no valid")
        return value
    }

    var value: T = validate(n)
        set(newValue) {
            field = validate(newValue)
        }

    operator fun plus(other: Number) = op(toDouble() + other.toDouble())
    operator fun minus(other: Number) = op(toDouble() - other.toDouble())
    operator fun times(other: Number) = op(toDouble() * other.toDouble())
    operator fun div(other: Number) = op(toDouble() / other.toDouble())
    operator fun inc() = plus(1)
    operator fun dec() = minus(1)

    private fun op(result: Double) = Num(result.cast(), constraint)

    @Suppress("UNCHECKED_CAST")
    private fun Double.cast(): T = when (value) {
        is Double -> this
        is Float -> toFloat()
        is Long -> toLong()
        is Int -> toInt()
        is Short -> toInt().toShort()
        is Byte -> toInt().toByte()
        else -> this
    } as T

    operator fun component1() = value
    override fun toDouble() = value.toDouble()
    override fun toFloat() = value.toFloat()
    override fun toLong() = value.toLong()
    override fun toInt() = value.toInt()
    override fun toShort() = value.toShort()
    override fun toByte() = value.toByte()

}