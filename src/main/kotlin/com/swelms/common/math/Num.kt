package com.swelms.common.math

open class Num<T : Number> (
    n: T,
    private val constraint: (T) -> Boolean = { true }
): Number() {
    private fun validate(v: T): T {
        require(constraint(v))
        return v
    }

    var value: T = validate(n)
        set(v) {
            field = validate(v)
        }

    operator fun plus(other: Number) = op(toDouble() + other.toDouble())
    operator fun minus(other: Number) = op(toDouble() - other.toDouble())
    operator fun times(other: Number) = op(toDouble() * other.toDouble())
    operator fun div(other: Number) = op(toDouble() / other.toDouble())
    operator fun inc() = plus(1)
    operator fun dec() = minus(1)

    private fun op(res: Double) = Num(res.cast(), constraint)

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