package swelms.common.validator

import swelms.common.locale.Locale
import swelms.common.reflection.qProperty
import swelms.common.text.replaceSlots
import swelms.common.locale.localeText

open class Validator<T>(
   val rule: Rule<T>
) : Validable<T>{
   constructor(
      message: String = defaultMessage,
      eval: (T) -> Boolean
   ) : this(Rule(message, eval))

   override fun validate(value: T): T {
      if (!rule.condition(value)) {
         val message = rule.message.replaceSlots(value.toString())
         throw ValidatorException(message)
      }
      return value
   }

   companion object{
      val defaultMessage: String = localeText("INVALID_VALUE")
   }

}

