package com.swelms.common.result

sealed interface Result<T> {
   val value: T?
   data class Success<T>(override val value: T) : Result<T>
   data class Fail<T>(val error: Throwable, override val value:T? = null ): Result<T>
}


fun <T> Result<T>.toKotlinResult(): kotlin.Result<T> =
   when (this) {
      is Result.Success -> kotlin.Result.success(value)
      is Result.Fail   -> kotlin.Result.failure(error)
   }

fun <T> kotlin.Result<T>.toSwelmsResult(): Result<T> =
   fold(
      onSuccess = { Result.Success(value = it) },
      onFailure = { Result.Fail(error = it) }
   )