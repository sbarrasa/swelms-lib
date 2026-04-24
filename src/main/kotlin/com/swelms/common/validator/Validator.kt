package com.swelms.common.validator

import com.swelms.common.text.StringSlots
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
         val hasSlots = StringSlots(rule.message).slots.isNotEmpty()
         val message = if (hasSlots) rule.message.replaceSlots(value.toString()) else rule.message
         throw ValidatorException(message)
      }
      return value
   }
}
