package com.swelms.common.type

interface BoolMap<out T> {
   val trueValue: T
   val falseValue: T

   operator fun get(value: Boolean): T = if (value) trueValue else falseValue
   operator fun invoke(block: () -> Boolean): T = get(block())

   operator fun not(): BoolMap<T> =
      BoolMap(falseValue, trueValue)
   companion object {
      operator fun <T> invoke(trueValue: T, falseValue: T) = EagerBoolMap(trueValue, falseValue)
   }
}
open class EagerBoolMap<out T>(override val trueValue: T, override val falseValue: T): BoolMap<T>{
   override operator fun not() = EagerBoolMap(falseValue, trueValue)
}


infix fun <T> T.orElse(falseValue: T): BoolMap<T> = EagerBoolMap(this, falseValue)

fun <T> Pair<T, T>.toBoolMap() = EagerBoolMap(this.first, this.second)

fun <T> BoolMap<T>.toPair() = Pair(this.trueValue, this.falseValue)

@Suppress("UNCHECKED_CAST")
fun <T, L:T, R:T> BoolMap<T>.toEither(condition: Boolean): Either<L, R> {
   return if (condition) {
      Either.Right(trueValue as R)
   } else {
      Either.Left(falseValue as L)
   }
}