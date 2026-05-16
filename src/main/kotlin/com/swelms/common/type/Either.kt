package com.swelms.common.type

sealed interface Either<out L, out R> {
   val value: Any?
   data class Left<out L>(override val value: L) : Either<L, Nothing>
   data class Right<out R>(override val value: R) : Either<Nothing, R>

   fun swap(): Either<R, L> =
      when (this) {
         is Left  -> Right(value)
         is Right -> Left(value)
      }
   companion object {
      inline fun <reified L, reified R> of(value: Any): Either<L, R> =
         when (value) {
            is R -> Right(value)
            is L -> Left(value)
            else -> error("Invalid type: ${value::class}")
         }
   }

}
