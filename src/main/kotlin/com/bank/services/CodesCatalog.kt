package com.bank.services

import com.bank.model.customer.Gender
import com.bank.model.products.structure.Branch
import com.bank.model.products.structure.Currency
import com.sbarrasa.fiscal.cuit.EntityCodes
import com.sbarrasa.fiscal.cuit.EntityType
import com.sbarrasa.id.map.Catalog
import com.sbarrasa.case.Case


object CodesCatalog: Catalog(Case.SNAKE) {
   init {
      put(EntityType::class)
      put(EntityCodes)
      put(ProductTypes)
      put(Gender::class)
      put(Branch::class)
      put(Currency::class)
   }
}

