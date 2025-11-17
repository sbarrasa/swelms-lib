package com.bank.dto.product

import com.bank.product.structure.Branch
import com.bank.product.structure.Card
import com.bank.product.structure.ProductDescriptor
import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("TD")
data class DebitCard(
   override val branch: Branch,
   override val number: String,
   override val expirationDate: LocalDate
) : Card() {
   override val descriptor: ProductDescriptor
      get() = Companion
   companion object: ProductDescriptor {
      override var id = "TD"
      override val description = "Tarjeta de débito"
   }
}