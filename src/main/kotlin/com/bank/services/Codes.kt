package com.bank.services

import com.bank.model.customer.Gender
import com.bank.model.products.structure.Currency
import com.swelms.domain.cuit.CuitEntityCodes
import com.swelms.common.collections.Catalog
import com.swelms.common.text.Case
import com.swelms.domain.card.CardBrand
import com.swelms.domain.cuit.Cuit


object Codes: Catalog(Case.SNAKE) {
   init {
      put(Cuit.EntityType::class) {it.description}
      put(CuitEntityCodes)
      put(ProductTypes)
      put(Gender::class) {it.description}
      put(CardBrand::class) { it.description }
      put(Currency::class) {it.description}
   }
}

