package swelms.common.type

fun <T> resultOf(block: () -> T): Result<T?> =
   try {
      Result.Success(block())
   } catch (e: Throwable) {
      Result.Fail(e)
   }



infix fun <T> Result<T>.orElse(block: (Result.Fail) -> T): Result<T?> =
    when (this) {
        is Result.Success -> this
        is Result.Fail -> resultOf { block(this) }
    }
