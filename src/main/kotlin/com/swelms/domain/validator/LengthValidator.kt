package com.swelms.domain.validator

import com.swelms.common.validator.Rule
import com.swelms.common.validator.Validator


class LengthValidator(message: String="invalid size", val size: Int) :
   Validator<String>(Rule(message) { it.length == size })
