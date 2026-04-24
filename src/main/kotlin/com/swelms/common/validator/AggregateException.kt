package com.swelms.common.validator

class AggregateException(val errors: List<Throwable>) : ValidatorException() {
   val messages: List<String>
      get() = errors.map { it.toAggregateMessage() }

   override val message: String
      get() = messages.joinToString("; ")
}

private fun Throwable.toAggregateMessage(): String {
   if (message.isNullOrBlank()) this::class.simpleName
   return message!!
}
