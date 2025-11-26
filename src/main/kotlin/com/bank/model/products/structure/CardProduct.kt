package com.bank.model.products.structure

import com.swelms.domain.id.card.CardNumber
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@Serializable
abstract class CardProduct : Product() {
   abstract val cardNumber: CardNumber
   abstract val expirationDate: LocalDate

   override val description: String
      get() =  "${descriptor?.description} ${cardNumber.brand?.description}"

}