package com.bank.model.products

import com.bank.model.products.Product
import com.swelms.domain.id.cbu.CBU
import com.swelms.domain.locale.Currency
import kotlinx.serialization.Serializable

@Serializable
sealed interface Account: Product {
   val cbu: CBU
   val currency: Currency

   override val description: String
      get() = "${this::class.descriptor.description} en ${currency.description}"

}