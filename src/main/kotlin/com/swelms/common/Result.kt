package com.swelms.common

sealed class Result<T>(open val value: T?, open val error: Throwable?) {
   data class Success<T>(override val value: T) : Result<T>(value, null)
   data class Error<T>(override val error: Throwable, override val value:T? = null ) : Result<T>(value, error)
}


fun <T> Result<T>.toKotlinResult(): kotlin.Result<T> =
   when (this) {
      is Result.Success -> kotlin.Result.success(value)
      is Result.Error   -> kotlin.Result.failure(error)
   }

fun <T> kotlin.Result<T>.fromKotlinResult(): Result<T> =
   fold(
      onSuccess = { Result.Success(value = it) },
      onFailure = { Result.Error(error = it) }
   )