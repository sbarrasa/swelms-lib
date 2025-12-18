package com.swelms.common.type

sealed class Either<L, R> {
   data class Left<L>(val value: L) : Either<L, Nothing>()
   data class Right<R>(val value: R) : Either<Nothing, R>()

   fun <T> fold(onLeft: (L) -> T, onRight: (R) -> T): T =
      when (this) {
         is Left -> onLeft(value)
         is Right -> onRight(value)
      }
}

