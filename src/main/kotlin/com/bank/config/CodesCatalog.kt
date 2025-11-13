package com.bank.config

import com.bank.dto.customer.Gender
import com.bank.dto.product.Branch
import com.bank.dto.product.Currency
import com.bank.dto.product.factory.ProductFactory
import com.sbarrasa.fiscal.cuit.EntityCodes
import com.sbarrasa.fiscal.cuit.EntityType
import com.sbarrasa.util.map.Catalog
import com.sbarrasa.util.case.Case


object CodesCatalog: Catalog(Case.SNAKE) {
   init {
      put(EntityType::class)
      put(EntityCodes)
      put("ProductTypes", ProductFactory.asMap())
      put(Gender::class)
      put(Branch::class)
      put(Currency::class)
   }
}

