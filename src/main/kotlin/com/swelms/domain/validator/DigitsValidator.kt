package com.swelms.domain.validator

import com.swelms.common.validator.Validator

class DigitsValidator(override val message: String="value must be a numeric digit"):
   Validator<String>(message, { it.all { char -> char.isDigit() }})