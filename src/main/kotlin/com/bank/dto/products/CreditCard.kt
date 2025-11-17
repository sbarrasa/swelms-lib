package com.bank.dto.products

import com.bank.dto.products.structure.Branch
import com.bank.dto.products.structure.Card
import com.bank.dto.products.structure.CreditProduct
import com.bank.dto.products.structure.ProductDescriptor
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