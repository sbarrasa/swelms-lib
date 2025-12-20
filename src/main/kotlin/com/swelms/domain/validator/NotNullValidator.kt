package com.swelms.domain.validator

import com.swelms.common.validator.Validator

class NotNullValidator(override val message: String = "value can't be null"):
   Validator<Any?>(message, { it != null })