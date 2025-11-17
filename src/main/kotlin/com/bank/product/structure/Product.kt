package com.bank.product.structure

import kotlinx.serialization.Serializable

@Serializable
abstract class Product: ProductDescriptor by Companion {

   companion object: ProductDescriptor {
      override var id: String
         get() = throw NotImplementedError("id not implemented")
         set(_) {}
      override val description: String
         get() = throw NotImplementedError("description not implemented")

   }


   val isCreditProduct get() = this is CreditProduct
   abstract fun fullDescription(): String
}