package com.swelms.domain.validator

class LengthValidator(override val message: String, val size: Int): Validator<String>  {
   override val condition: (String) -> Boolean
      get() = {value -> (value.length == size) }

}