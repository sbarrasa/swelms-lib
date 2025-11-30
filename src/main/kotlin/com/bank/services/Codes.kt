package com.bank.services

import com.swelms.domain.person.Gender
import com.bank.model.products.structure.CurrencySet
import com.swelms.common.collections.*
import com.swelms.common.locale.localeText
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
      put(CurrencySet.associate { it.name to it.localeDescription })
   }
}

