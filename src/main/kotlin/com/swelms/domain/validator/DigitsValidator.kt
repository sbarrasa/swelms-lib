package com.swelms.domain.validator

class DigitsValidator(override val message: String): Validator<String> {
   override val condition: (String) -> Boolean
      get() = {value -> value.all { char -> char.isDigit() }}
}