package com.bank.services

import com.bank.model.customer.Gender
import com.bank.model.products.structure.Currency
import com.swelms.domain.id.cuit.CuitEntityCodes
import com.swelms.common.collections.Catalog
import com.swelms.common.collections.enumMapOf
import com.swelms.common.text.Case
import com.swelms.domain.id.card.CardBrand
import com.swelms.domain.id.cuit.Cuit


object Codes: Catalog(Case.SNAKE) {
   init {
      put(enumMapOf<Cuit.EntityType> { it.description })
      put(CuitEntityCodes)
      put(ProductTypes)
      put(enumMapOf<Gender>{ it.description })
      put(enumMapOf<CardBrand>{ it.description })
      put(enumMapOf<Currency>{ it.description })
   }
}

