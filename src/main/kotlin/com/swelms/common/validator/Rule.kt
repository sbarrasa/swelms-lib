package com.swelms.common.validator

data class Rule<T>(
   val message: String = "Invalid value {1}",
   val condition: (T) -> Boolean
)
