package com.swelms.common.type

sealed interface Either<out L, out R> {
   data class Left<out L>(val value: L) : Either<L, Nothing>
   data class Right<out R>(val value: R) : Either<Nothing, R>

   fun leftOrNull(): L? =
      when (this) {
         is Left  -> value
         is Right -> null
      }

   fun rightOrNull(): R? =
      when (this) {
         is Left  -> null
         is Right -> value
      }

   fun <T> fold(ifLeft: (L) -> T, ifRight: (R) -> T): T =
      when (this) {
         is Left  -> ifLeft(value)
         is Right -> ifRight(value)
      }

   fun <T> map(transform: (R) -> T): Either<L, T> =
      when (this) {
         is Left  -> this
         is Right -> Right(transform(value))
      }

   fun <T> mapLeft(transform: (L) -> T): Either<T, R> =
      when (this) {
         is Left  -> Left(transform(value))
         is Right -> this
      }

   fun <A, B> bimap(ifLeft: (L) -> A, ifRight: (R) -> B): Either<A, B> =
      when (this) {
         is Left  -> Left(ifLeft(value))
         is Right -> Right(ifRight(value))
      }


   fun swap(): Either<R, L> =
      when (this) {
         is Left  -> Right(value)
         is Right -> Left(value)
      }
}

fun <L, R, T> Either<L, R>.getOrElse(default: T): T where R : T =
   fold(
      ifLeft = { default },
      ifRight = { it }
   )

fun <L, R, T> Either<L, R>.getOrElse(default: (L) -> T): T where R : T =
   fold(
      ifLeft = default,
      ifRight = { it }
   )
