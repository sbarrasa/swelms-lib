package com.swelms.common.validator

interface Validable<T> {
   fun validate(obj: T): T

}
