package com.bank.locale

import com.swelms.common.locale.AbstractRegionalConfig
import com.swelms.domain.locale.Currency
import kotlin.collections.set

object LocaleConfig_us: AbstractRegionalConfig {
   override val locale_id = "us"

   override val valueMap = mapOf(
      "CURRENCY" to Currency.USD,
      "DATE_FORMAT" to "MM-dd-yyyy"
   )
}