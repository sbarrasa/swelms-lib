package com.swelms.common.math

open class Num<T : Number> (
    n: T,
    private val constraint: (T) -> Boolean = { true }
): Number() {

    private fun validate(value: T): T = value.also {
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

    private fun op(result: Double) = Num(cast(result), constraint)

    @Suppress("UNCHECKED_CAST")
    private fun cast(n: Double): T = when (value) {
        is Double -> n
        is Float -> n.toFloat()
        is Long -> n.toLong()
        is Int -> n.toInt()
        is Short -> n.toInt().toShort()
        is Byte -> n.toInt().toByte()
        else -> n
    } as T

    operator fun component1() = value
    override fun toDouble() = value.toDouble()
    override fun toFloat() = value.toFloat()
    override fun toLong() = value.toLong()
    override fun toInt() = value.toInt()
    override fun toShort() = value.toShort()
    override fun toByte() = value.toByte()

}