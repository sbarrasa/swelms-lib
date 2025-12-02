package com.bank.model.products.structure

import kotlinx.serialization.Serializable
import kotlin.reflect.full.companionObjectInstance

@Serializable
abstract class Product {
   abstract val description: String

   val isCredit get() = this is CreditProduct

   val descriptor: ProductDescriptor?
      get() = this::class.companionObjectInstance as? ProductDescriptor

   companion object {
      const val MODULE = "products"
   }


}