package com.bank.model.products

import com.bank.model.products.structure.CardBranch
import com.bank.model.products.structure.Card
import com.bank.model.products.structure.CreditProduct
import com.bank.model.products.structure.ProductDescriptor
import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName(CreditCard.TYPE)
data class CreditCard(
   override val branch: CardBranch,
   override val number: String,
   override var expirationDate: LocalDate,
   override var creditLimit: Double,
   val tier: String
) : Card(), CreditProduct {
   companion object: ProductDescriptor {
      const val TYPE = "TC"
      override val id get() = TYPE
      override val description = "Tarjeta de crédito"
   }

   override val description: String
      get() =  "${super.description} $tier"

}