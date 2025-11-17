package com.bank.products.structure

import kotlinx.serialization.Serializable

@Serializable
abstract class Product {
   abstract val descriptor: ProductDescriptor

   val isCredit get() = this is CreditProduct
   abstract fun fullDescription(): String
}