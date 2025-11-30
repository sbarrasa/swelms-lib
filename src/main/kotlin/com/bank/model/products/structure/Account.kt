package com.bank.model.products.structure

import com.swelms.domain.id.cbu.CBU
import com.swelms.domain.locale.Currency
import kotlinx.serialization.Serializable

@Serializable
abstract class Account: Product() {
   abstract val cbu: CBU
   abstract val currency: Currency

   override val description: String
      get() = "${descriptor?.description} en ${currency.description}"

}