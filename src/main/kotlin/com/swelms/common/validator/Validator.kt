package com.swelms.common.validator


open class Validator<T>(
   open val message: String = "Invalid value",
   open val condition: (T) -> Boolean
) : Validable<T> {
   override fun validate(obj: T): T {
      if (!condition(obj)) throw ValidatorException(message)
      return obj
   }
}
