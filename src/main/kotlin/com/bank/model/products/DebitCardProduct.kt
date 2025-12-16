package com.bank.model.products

import com.swelms.domain.id.card.CardNumber
import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName(DebitCardProduct.TYPE_ID)
data class DebitCardProduct(
   override val cardNumber: CardNumber,
   override val expirationDate: LocalDate
) : Product, CardProduct {

   companion object: ProductDescriptor {
      const val TYPE_ID = "TD"
      override val typeId get() = TYPE_ID
   }
}