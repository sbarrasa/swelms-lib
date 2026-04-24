package com.swelms.domain.validator

import com.swelms.common.validator.Rule
import com.swelms.common.validator.Validator

class DigitsValidator(message: String="value must be a numeric digit"):
   Validator<String>(Rule(message) { it.all { char -> char.isDigit() }})
