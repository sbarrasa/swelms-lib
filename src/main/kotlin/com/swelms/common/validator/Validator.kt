package com.swelms.common.validator


open class Validator<T>(
   open val message: String = "Invalid value",
   open val condition: (T) -> Boolean
) : Validable<T> {
   override fun validate(value: T): T {
      if (!condition(value)) throw ValidatorException(message)
      return value
   }
}
