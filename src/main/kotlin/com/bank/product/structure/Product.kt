package com.bank.product.structure

import kotlinx.serialization.Serializable

@Serializable
abstract class Product: ProductDescriptor {
   abstract val descriptor: ProductDescriptor

   override var id
      get() = descriptor.id
      set(id) { descriptor.id = id }

   override val description get() = descriptor.description
   val isCreditProduct get() = this is CreditProduct
   abstract fun fullDescription(): String
}