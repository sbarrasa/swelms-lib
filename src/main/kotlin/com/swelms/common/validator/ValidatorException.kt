package com.swelms.common.validator

class ValidatorException(override val message: String?) : IllegalArgumentException(message)