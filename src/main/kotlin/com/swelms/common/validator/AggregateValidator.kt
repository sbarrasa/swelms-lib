package com.swelms.common.validator

import com.swelms.common.result.Result
import com.swelms.common.result.resultOf

class AggregateValidator<T>(vararg val rules: (T) -> Unit) : Validable<T> {
   override fun validate(value: T): T {
      val errors = mutableListOf<Throwable>()
      for (rule in rules) {
         val result = resultOf { rule(value) }
         if (result is Result.Fail) {
            errors += result.error
         }
      }

      if (errors.isNotEmpty()) throw AggregateException(errors)
      return value
   }

   fun evaluateAll(value: T): List<Result<T>> {
      val results = mutableListOf<Result<T>>()
      for (rule in rules) {
         val result = resultOf {
            rule(value)
            value
         }
         when (result) {
            is Result.Success -> results += Result.Success(value)
            is Result.Fail -> results += result
         }
      }
      return results
   }
}
