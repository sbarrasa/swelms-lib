package com.bank.model.products

import com.bank.model.products.ProductDescriptor
import kotlinx.serialization.Serializable
import kotlin.reflect.full.companionObjectInstance

@Serializable
sealed interface Product {
   val description: String

   val isCredit get() = this is CreditProduct

   val descriptor: ProductDescriptor?
      get() = this::class.companionObjectInstance as? ProductDescriptor

   companion object {
      val types get() = Product::class.sealedSubclasses.filter { it.isFinal }
   }

}