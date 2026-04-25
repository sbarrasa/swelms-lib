package com.swelms.common.validator

import com.swelms.common.result.Result

class AggregateValidator<T>(vararg val rules: Rule<T>) : Validable<T> {
   override fun validate(value: T): T {
      val errors = mutableListOf<Throwable>()
      for (rule in rules) {
         val validator = Validator(rule)
         val result = validator.evaluate(value)
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
         val result = Validator(rule).evaluate(value)
         results += when (result) {
           // TODO("definir que hacer con los casos succes")
            is Result.Success -> Result.Success(value)
            is Result.Fail -> result
         }
      }
      return results
   }
}

fun <T> validatorOf(vararg rules: Rule<T> ): Validable<T> {
   return if(rules.size == 1) Validator(rules[0])
   else AggregateValidator(*rules)
}