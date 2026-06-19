package swelms.domain.validator

import swelms.common.locale.*
import swelms.common.validator.Rule
import swelms.common.validator.Validator


class LengthValidator(message: String=defaultMessage, val size: Int) :
   Validator<String>(
      Rule(message) {
         it.length == size
      }
   )
{
   companion object {
      val defaultMessage = localeText("INVALID_SIZE")
   }
}
