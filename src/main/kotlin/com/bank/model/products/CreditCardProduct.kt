package com.bank.model.products

import com.swelms.common.serialization.serialName
import com.swelms.domain.id.card.CardNumber
import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("TC")
data class CreditCardProduct(
   override val cardNumber: CardNumber,
   override var expirationDate: LocalDate,
   override var creditLimit: Double,
   val tier: String
) : Product, CardProduct, CreditProduct {

   override val description: String
      get() =  "${super.description} $tier"

}