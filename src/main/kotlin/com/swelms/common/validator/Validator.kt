package com.swelms.common.validator

import com.swelms.common.text.replaceSlots


open class Validator<T>(
   val rule: Rule<T>
) : Validable<T> {
   constructor(
      message: String = "Invalid value {1}",
      condition: (T) -> Boolean
   ) : this(Rule(message, condition))


   override fun validate(value: T): T {
      if (!rule.condition(value)) {
         val message = rule.message.replaceSlots(value.toString())
         throw ValidatorException(message)
      }
      return value
   }
}

