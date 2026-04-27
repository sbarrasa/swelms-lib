package com.swelms.common.validator

import com.swelms.common.type.resultOf

interface Validable<T> {
   fun validate(value: T): T
   fun evaluate(value: T) = resultOf { validate(value) }

}
