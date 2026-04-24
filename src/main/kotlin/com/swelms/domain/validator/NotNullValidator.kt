package com.swelms.domain.validator

import com.swelms.common.validator.Rule
import com.swelms.common.validator.Validator

class NotNullValidator(message: String =  "value can't be null"):
   Validator<Any?>(Rule(message) { it != null })
