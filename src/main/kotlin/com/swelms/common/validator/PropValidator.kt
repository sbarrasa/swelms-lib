package com.swelms.common.validator

class PropValidator<R>(
   val property: () -> R,
   val validator: Validable<R>
) {
   fun validate() = validator.validate(property())
}

infix fun <R> (() -> R).mustBe(condition: (R) -> Boolean) =
   PropValidator(this, Validator(condition = condition))

infix fun <R> (() -> R).validatesWith(validator: Validable<R>) =
   PropValidator(this, validator)

