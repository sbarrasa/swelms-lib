package com.bank.model.products

import com.bank.model.products.CardProduct
import com.bank.model.products.CreditProduct
import com.bank.model.products.Product
import com.bank.model.products.ProductDescriptor
import com.swelms.domain.id.card.CardNumber
import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName(CreditCardProduct.TYPE)
data class CreditCardProduct(
   override val cardNumber: CardNumber,
   override var expirationDate: LocalDate,
   override var creditLimit: Double,
   val tier: String
) : Product, CardProduct, CreditProduct {
   companion object: ProductDescriptor {
      const val TYPE = "TC"
      override val type get() = TYPE
   }

   override val description: String
      get() =  "${super.description} $tier"

}