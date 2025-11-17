package com.bank.dto.products

import com.bank.dto.products.structure.Branch
import com.bank.dto.products.structure.Card
import com.bank.dto.products.structure.ProductDescriptor
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

   companion object: ProductDescriptor {
      const val TYPE = "TD"
      override val id get() = TYPE
      override val description = "Tarjeta de débito"
   }

   override val id: String
      get() = number

   override val description: String
      get() =  "${Companion.description} ${branch.description}"

}