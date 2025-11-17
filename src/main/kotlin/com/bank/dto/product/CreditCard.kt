package com.bank.dto.product

import com.bank.product.structure.Branch
import com.bank.product.structure.Card
import com.bank.product.structure.CreditProduct
import com.bank.product.structure.ProductDescriptor
import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("TC")
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
      override var id = "TC"
      override val description = "Tarjeta de crédito"
   }

   override fun fullDescription() = "${super.fullDescription()} $tier"
}