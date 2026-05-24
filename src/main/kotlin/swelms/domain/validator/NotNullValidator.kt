package swelms.domain.validator

import swelms.common.validator.Rule
import swelms.common.validator.Validator

class NotNullValidator(message: String =  "value can't be null"):
   Validator<Any?>(Rule(message) { it != null })
