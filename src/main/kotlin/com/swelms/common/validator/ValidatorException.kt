package com.swelms.common.validator

open class ValidatorException(override val message: String?) : IllegalArgumentException(message){
    constructor(): this(null)
}