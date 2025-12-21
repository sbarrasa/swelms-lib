package com.swelms.common.type


sealed class Res<T>(open val value: T?, open val error: Throwable?) {
   data class Success<T>(override val value: T) : Res<T>(value, null)
   data class Error<T>(override val value: T?=null, override val error: Throwable) : Res<T>(value, error)

   infix fun orElse(block: (Res<T>) -> T): T = value ?: block(this)
   infix fun orElse(defaultValue: T) = orElse { defaultValue }

   infix fun orAny(block: (Res<T>) -> Any?): Any? = value ?: block(this)
   infix fun orAny(defaultValue: Any?) = orAny { defaultValue }

   infix fun onError(block: (Throwable) -> Unit): Res<T> {
      error?.let(block)
      return this
   }
}


fun <T> Res<T>.toResult(): Result<T> =
   when (this) {
      is Res.Success -> Result.success(value)
      is Res.Error   -> Result.failure(error)
   }

fun <T> Result<T>.fromResult(): Res<T> =
   fold(
      onSuccess = { Res.Success(value = it) },
      onFailure = { Res.Error(error = it) }
   )