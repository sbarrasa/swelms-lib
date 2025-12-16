package com.bank.model.products

import com.swelms.domain.locale.Currency

object ActiveCurrencySet : Set<Currency> by setOf(
   Currency.USD,
   Currency.EUR,
   Currency.ARS,
   Currency.BRL
)