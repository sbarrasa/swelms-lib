package com.bank.model.products

import com.bank.model.products.CardProduct
import com.bank.model.products.Product
import com.bank.model.products.ProductDescriptor
import com.swelms.domain.id.card.CardNumber
import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName(DebitCardProduct.TYPE)
data class DebitCardProduct(
   override val cardNumber: CardNumber,
   override val expirationDate: LocalDate
) : Product, CardProduct {

   companion object: ProductDescriptor {
      const val TYPE = "TD"
      override val type get() = TYPE
   }
}