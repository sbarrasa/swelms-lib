package com.bank.services

import com.bank.model.customer.Gender
import com.bank.model.products.structure.Currency
import com.sbarrasa.domain.cuit.CuitEntityCodes
import com.sbarrasa.common.collections.Catalog
import com.sbarrasa.common.text.Case
import com.sbarrasa.domain.card.CardBrand
import com.sbarrasa.domain.cuit.Cuit


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

