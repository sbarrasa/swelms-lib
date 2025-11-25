package com.swelms.domain.validator

class LengthValidator(val msg: String, val size: Int)  {
   fun validate(value: String){
      if (value.length != size) throw ValidatorException(msg)

   }
}