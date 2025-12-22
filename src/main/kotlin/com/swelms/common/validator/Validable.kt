package com.swelms.common.validator

import com.swelms.common.type.Result

interface Validable<T> {
   fun validate(value: T): T

   fun evaluate(value: T): Result<T>{
      try {
         validate(value)
         return Result.Success(value)
      }catch (e: Exception){
         return Result.Error(value = value, error = e)
      }
   }

}
