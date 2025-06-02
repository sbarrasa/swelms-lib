package com.bank.service

import com.bank.model.customer.Gender
import com.bank.model.product.Branch
import com.bank.model.product.Currency
import com.bank.model.product.factory.ProductTypes
import com.sbarrasa.util.CaseType.SNAKE
import com.sbarrasa.util.simpleName

object Codes : Map<String, Map<String, String>> by mapOf(
   ProductTypes::class.simpleName(SNAKE) to ProductTypes.asMap(),
   Branch::class.simpleName(SNAKE) to Branch.asMap(),
   Currency::class.simpleName(SNAKE) to Currency.asMap(),
   Gender::class.simpleName(SNAKE) to Gender.asMap()
)
