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

fun <T> Res<T>.toEither() = when(this) {
   is Res.Success -> Either.Right(value)
   is Res.Error -> Either.Left(error)
}

fun <T> Either<Throwable,T>.toRes() = when(this) {
   is Either.Left -> Res.Error(error = value)
   is Either.Right -> Res.Success(value = value)
}



