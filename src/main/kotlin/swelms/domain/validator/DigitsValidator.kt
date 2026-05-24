package swelms.domain.validator

import swelms.common.validator.*

class DigitsValidator(message: String="value must be a numeric digit"):
   Validator<String>(Rule(message) { it.all { char -> char.isDigit() }})
