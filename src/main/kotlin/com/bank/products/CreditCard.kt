package com.bank.products

import com.bank.products.structure.Branch
import com.bank.products.structure.Card
import com.bank.products.structure.CreditProduct
import com.bank.products.structure.ProductDescriptor
import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName(CreditCard.TYPE)
data class CreditCard(
   override val branch: Branch,
   override val number: String,
   override var expirationDate: LocalDate,
   override var creditLimit: Double,
   val tier: String
) : Card(), CreditProduct {
   override val descriptor: ProductDescriptor
      get() = Companion

   companion object: ProductDescriptor {
      const val TYPE = "TC"
      override val id = TYPE
      override val description = "Tarjeta de crédito"
   }

   override fun fullDescription() = "${super.fullDescription()} $tier"
}