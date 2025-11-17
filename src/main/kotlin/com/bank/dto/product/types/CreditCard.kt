package com.bank.dto.product.types

import com.bank.dto.product.ProductDescriptor

class CreditCard : Card(CreditCard), CreditProduct {
   override var creditLimit: Double? = null
   var tier: String? = null

   override fun fullDescription() = "${super.fullDescription()} ${tier ?: ""}".trimEnd()

   companion object : ProductDescriptor {
      override var id = "TC"
      override val description = "Tarjeta de crédito"
   }
}