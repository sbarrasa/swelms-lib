package com.bank.modules

import com.bank.model.customer.Gender
import com.bank.model.product.Branch
import com.bank.model.product.Currency
import com.bank.model.product.factory.ProductFactory
import com.sbarrasa.cuit.EntityCodeMap
import com.sbarrasa.cuit.EntityType
import com.sbarrasa.util.case.Case
import com.sbarrasa.util.id.CodesClassMap

object Codes: CodesClassMap (
   keyCase = Case.SNAKE,
   classes = listOf(
      ProductFactory,
      Branch,
      Currency,
      Gender,
      EntityType,
      EntityCodeMap,
   )
)
