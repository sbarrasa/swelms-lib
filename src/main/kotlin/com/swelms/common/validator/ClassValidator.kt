package com.swelms.common.validator

import com.swelms.common.type.*

class ClassValidator(vararg val validations: Validation<*, *>): Validable<Any> {

   class Validation<T, R>(
      val property: (T) -> R,
      val validator: Validable<R>
   ) {
      fun validate(receiver: T): R {
         val value = property(receiver)
         validator.validate(value)
         return value
      }
   }

   override fun validate(obj: Any): Any {
      validations.forEach {
         @Suppress("UNCHECKED_CAST")
         (it as Validation<Any, Any?>).validate(obj)
      }
      return obj
   }

   fun evaluate(obj: Any): List<ValResult<Any?>> =
      validations.map {
         @Suppress("UNCHECKED_CAST")
         tryGet { (it as Validation<Any, Any?>).validate(obj) }
      }
}


infix fun <T, R> (T.() -> R).mustBe(condition: (R) -> Boolean) = ClassValidator.Validation(this, Validator(condition = condition))

infix fun <T, R> (T.() -> R).validatesWith(validator: Validable<R>) = ClassValidator.Validation(this, validator)
