package com.swelms.domain.validator

class DigitsValidator(val msg: String) {
   fun validate(value: String) {
      if (!value.all { it.isDigit() }) throw ValidatorException(msg)
   }
}