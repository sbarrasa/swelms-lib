package com.swelms.domain.validator

import com.swelms.common.validator.Validator


class LengthValidator(override val message: String="invalid size", val size: Int) :
   Validator<String>(message, { it.length == size })