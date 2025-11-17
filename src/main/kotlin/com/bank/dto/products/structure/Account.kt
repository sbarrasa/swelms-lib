package com.bank.dto.products.structure

import kotlinx.serialization.Serializable

@Serializable
abstract class Account: Product() {
   abstract val cbu: String
   abstract val currency: Currency
}