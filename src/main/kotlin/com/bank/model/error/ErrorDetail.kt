package com.bank.model.error

import kotlinx.serialization.Serializable

@Serializable
data class ErrorDetail(
   val type: String,
   val message: String
){
   constructor(cause: Throwable) : this(
      cause::class.simpleName!!,
      cause.message ?: cause.toString()
   )

}