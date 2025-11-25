package com.swelms.domain.validator

class ValidatorException(override val message: String?) : IllegalArgumentException(message)