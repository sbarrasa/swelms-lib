package com.swelms.common.type


sealed class ValResult<T>(open val value: T?, open val error: Throwable?) {
   data class Success<T>(override val value: T) : ValResult<T>(value, null)
   data class Error<T>(override val error: Throwable) : ValResult<T>(null, error)

   infix fun orElse(block: (ValResult<T>) -> T): T = value ?: block(this)
   infix fun orElse(defaultValue: T) = orElse { defaultValue }

   infix fun orAny(block: (ValResult<T>) -> Any?): Any? = value ?: block(this)
   infix fun orAny(defaultValue: Any?) = orAny { defaultValue }

   infix fun onError(block: (Throwable) -> Unit): ValResult<T> {
      error?.let(block)
      return this
   }
}


fun <T> ValResult<T>.toResult(): Result<T> =
   when (this) {
      is ValResult.Success -> Result.success(value)
      is ValResult.Error   -> Result.failure(error)
   }

fun <T> Result<T>.fromResult(): ValResult<T> =
   fold(
      onSuccess = { ValResult.Success(value = it) },
      onFailure = { ValResult.Error(error = it) }
   )