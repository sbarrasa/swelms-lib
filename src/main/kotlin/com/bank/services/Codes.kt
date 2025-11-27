package com.bank.services

import com.bank.model.customer.Gender
import com.bank.model.products.structure.Currency
import com.swelms.common.collections.*
import com.swelms.common.text.Case
import com.swelms.domain.id.card.CardBrand
import com.swelms.domain.id.cuit.*


object Codes: Catalog(Case.SNAKE) {
   init {
      put(Cuit.EntityType::class.mapTo { it.description })
      put(CuitEntityCodes)
      put(ProductTypes)
      put(Gender::class.mapTo { it.description })
      put(CardBrand::class.mapTo { it.description })
      put(Currency::class.mapTo { it.description })
   }
}

