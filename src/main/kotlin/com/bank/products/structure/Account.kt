package com.bank.products.structure

import kotlinx.serialization.Serializable

@Serializable
abstract class Account: Product() {
   abstract val cbu: String
   abstract val currency: Currency

   override fun fullDescription() = "${descriptor.description} en ${currency.description}"
}