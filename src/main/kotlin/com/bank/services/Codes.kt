package com.bank.services

import com.bank.model.products.structure.ActiveCurrencySet
import com.swelms.domain.person.Gender
import com.swelms.common.collections.*
import com.swelms.common.text.Case
import com.swelms.domain.id.card.CardBrand
import com.swelms.domain.id.cuit.*
import com.swelms.domain.locale.Currency


object Codes: Catalog(Case.SNAKE) {
   init {
      put(Cuit.EntityType.entries.mapTo { it.description })
      put(CuitEntityCodes)
      put(ProductTypes)
      put(Gender.entries.mapTo { it.description })
      put(CardBrand.entries.mapTo { it.description })
      put(ActiveCurrencySet.mapTo{ it.localeDescription})
   }
}

