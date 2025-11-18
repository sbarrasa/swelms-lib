package com.bank.services

import com.bank.model.customer.Gender
import com.bank.model.products.structure.CardBranch
import com.bank.model.products.structure.Currency
import com.sbarrasa.legal.cuit.CuitEntityCodes
import com.sbarrasa.legal.cuit.LegalEntity
import com.sbarrasa.id.map.Catalog
import com.sbarrasa.case.Case


//TODO: transformar en MemRepository
object CodesCatalog: Catalog(Case.SNAKE) {
   init {
      put(LegalEntity::class)
      put(CuitEntityCodes)
      put(ProductTypes)
      put(Gender::class)
      put(CardBranch::class)
      put(Currency::class)
   }
}

