package com.bank.model.products

import com.swelms.domain.id.card.CardNumber
import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName(CreditCardProduct.TYPE_ID)
data class CreditCardProduct(
   override val cardNumber: CardNumber,
   override var expirationDate: LocalDate,
   override var creditLimit: Double,
   val tier: String
) : Product, CardProduct, CreditProduct {
   companion object: ProductDescriptor {
      const val TYPE_ID = "TC"
      override val typeId get() = TYPE_ID
   }

   override val description: String
      get() =  "${super.description} $tier"

}