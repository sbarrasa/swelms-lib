package com.bank.modules

import com.bank.model.customer.Gender
import com.bank.model.product.Branch
import com.bank.model.product.Currency
import com.bank.model.product.factory.ProductTypes
import com.sbarrasa.cuit.EntityCodeMap
import com.sbarrasa.cuit.EntityType
import com.sbarrasa.util.Case
import com.sbarrasa.util.id.CodesClassMap

object Codes: CodesClassMap (
   keyCase = Case.SNAKE,
   classes = listOf(
      ProductTypes,
      Branch,
      Currency,
      Gender,
      EntityType,
      EntityCodeMap,
   )
)
