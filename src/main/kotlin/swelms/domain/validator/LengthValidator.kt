package swelms.domain.validator

import swelms.common.validator.Rule
import swelms.common.validator.Validator


class LengthValidator(message: String="invalid size", val size: Int) :
   Validator<String>(Rule(message) { it.length == size })
