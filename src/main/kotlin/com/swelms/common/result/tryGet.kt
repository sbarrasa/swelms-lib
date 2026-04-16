package com.swelms.common.result

fun <T> tryGet(attempts: Int = 1, block: () -> T): Result<T?> {
   require(attempts >= 1) { "attempts must be positive number" }
   val errors = mutableListOf<Throwable>()
   repeat(attempts) {
      try {
         return Result.Success(block())
      } catch (e: Exception) {
         errors.add(e)
      }
   }
   return if(attempts==1)
            Result.Error(errors.last())
         else
            Result.Error(AccumulatedException(errors))
}

inline infix fun <T, R> Result<T>.orElse(block: (Result<T>) -> R): R where T : R =
   when (this) {
      is Result.Success -> value
      is Result.Error -> block(this)
   }

inline infix fun <T> Result<T>.onError(block: (Throwable) -> Unit): Result<T> {
   error?.let {block(it)}
   return this
}
