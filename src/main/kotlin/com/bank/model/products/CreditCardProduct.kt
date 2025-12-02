package com.bank.model.products

import com.bank.model.products.structure.CardProduct
import com.bank.model.products.structure.CreditProduct
import com.bank.model.products.structure.Product
import com.bank.model.products.structure.ProductDescriptor
import com.swelms.common.locale.Locale
import com.swelms.common.text.snakeCase
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
) : CardProduct(), CreditProduct {
   companion object: ProductDescriptor {
      const val TYPE = "TC"
      override val type get() = TYPE
   }

   override val description: String
      get() =  "${super.description} $tier"

}