package com.bank.model.products

import com.swelms.domain.id.cbu.CBU
import com.swelms.domain.locale.Currency

interface Account: Product {
   val cbu: CBU
   val currency: Currency

   override val description: String
      get() = "${descriptor.description } en ${currency.description}"

}