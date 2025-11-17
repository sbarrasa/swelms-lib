package com.bank.services

import com.bank.dto.customer.Gender
import com.bank.products.structure.Branch
import com.bank.products.structure.Currency
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

