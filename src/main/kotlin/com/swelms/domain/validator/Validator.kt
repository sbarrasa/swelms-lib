package com.swelms.domain.validator

interface Validator<T> {
   val message: String
   val condition: (T) -> Boolean

   fun validate(value: T)  {
      if(!condition(value)) throw ValidatorException(message)
   }
}