package com.bank.products

import com.bank.products.structure.Branch
import com.bank.products.structure.Card
import com.bank.products.structure.ProductDescriptor
import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName(DebitCard.TYPE)
data class DebitCard(
   override val branch: Branch,
   override val number: String,
   override val expirationDate: LocalDate
) : Card() {
   override val descriptor: ProductDescriptor
      get() = Companion

   companion object: ProductDescriptor {
      const val TYPE = "TD"
      override val id = TYPE
      override val description = "Tarjeta de débito"
   }
}