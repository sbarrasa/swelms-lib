package com.bank.modules

import com.bank.model.customer.Gender
import com.bank.model.product.Branch
import com.bank.model.product.Currency
import com.bank.model.product.factory.ProductFactory
import com.sbarrasa.cuit.EntityCodeMap
import com.sbarrasa.cuit.EntityType
import com.sbarrasa.util.case.Case
import com.sbarrasa.id.IdDescClassMap

object Codes: IdDescClassMap (
   keyCase = Case.SNAKE,
   ProductFactory,
      EntityType::class,
      Branch::class,
      Currency::class,
      Gender::class,
      EntityCodeMap,
   )

