package com.swelms.common.validator

class AggregateException(val errors: List<Throwable>) : ValidatorException() {
   val messages: List<String>
      get() = errors.map { it.message ?: this::class.simpleName!! }

   override val message: String
      get() = messages.joinToString("; ")

}

