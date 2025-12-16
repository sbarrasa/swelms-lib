package com.bank.model.products

import com.swelms.common.serialization.serialName
import com.swelms.domain.id.card.CardNumber
import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("TD")
data class DebitCardProduct(
   override val cardNumber: CardNumber,
   override val expirationDate: LocalDate
) : Product, CardProduct