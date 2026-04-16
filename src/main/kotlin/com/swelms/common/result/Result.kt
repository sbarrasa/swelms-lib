package com.swelms.common.result

sealed class Result<T>(open val value: T?, open val error: Throwable?) {
   data class Success<T>(override val value: T) : Result<T>(value, null)
   data class Fail<T>(override val error: Throwable, override val value:T? = null ) : Result<T>(value, error)
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