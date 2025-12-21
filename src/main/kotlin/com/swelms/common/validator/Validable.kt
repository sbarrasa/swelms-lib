package com.swelms.common.validator

import com.swelms.common.type.Res

interface Validable<T> {
   fun validate(value: T): T

   fun evaluate(value: T): Res<T>{
      try {
         validate(value)
         return Res.Success(value)
      }catch (e: Exception){
         return Res.Error(value = value, error = e)
      }
   }

}
