package com.bank.model.products.structure

import com.sbarrasa.id.IdDesc
import kotlinx.serialization.Serializable
import kotlin.reflect.full.companionObjectInstance

@Serializable
abstract class Product: IdDesc<String> {
   val isCredit get() = this is CreditProduct

   val descriptor: ProductDescriptor?
      get() = this::class.companionObjectInstance as? ProductDescriptor
}