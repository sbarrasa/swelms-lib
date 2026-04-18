package com.swelms.common.validator

import com.swelms.common.text.replaceSlots


open class Validator<T>(
   open val message: String = "Invalid value {1}",
   open val condition: (T) -> Boolean
) : Validable<T> {
   override fun validate(value: T): T {
      if (!condition(value)) throw ValidatorException(message.replaceSlots(value.toString()))
      return value
   }
}
