package com.bank.model.products.structure

import com.swelms.domain.locale.*

object ActiveCurrencySet : Set<Currency> by setOf(
   Currency.USD,
   Currency.EUR,
   Currency.ARS,
   Currency.BRL
)