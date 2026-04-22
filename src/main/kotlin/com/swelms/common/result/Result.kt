package com.swelms.common.result

sealed interface Result<out T> {
   val value: T?
   operator fun component1(): T? = value
   class Success<T>(override val value: T) : Result<T>
   class Fail(val error: Throwable): Result<Nothing> {
      override val value get() = null
   }
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