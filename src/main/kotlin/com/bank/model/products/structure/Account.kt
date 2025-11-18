package com.bank.model.products.structure

import kotlinx.serialization.Serializable

@Serializable
abstract class Account: Product() {
   abstract val cbu: String
   abstract val currency: Currency

   override val id: String
      get() = cbu

   override val description: String
      get() = "${descriptor?.description} en ${currency.description}"

}