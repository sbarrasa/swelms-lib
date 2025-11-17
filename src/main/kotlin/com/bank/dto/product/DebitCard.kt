package com.bank.dto.product

import com.bank.product.structure.Branch
import com.bank.product.structure.Card
import com.bank.product.structure.ProductDescriptor
import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName(DebitCard.type)
data class DebitCard(
   override val branch: Branch,
   override val number: String,
   override val expirationDate: LocalDate
) : Card() {

   companion object: ProductDescriptor {
      const val type = "TD"
      override var id = type
      override val description = "Tarjeta de débito"
   }
}