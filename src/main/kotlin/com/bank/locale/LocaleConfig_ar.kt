package com.bank.locale

import com.swelms.common.locale.AbstractRegionalConfig
import com.swelms.domain.locale.Currency

object LocaleConfig_ar: AbstractRegionalConfig {
   override val locale_id = "ar"

   override val valueMap: Map<String, Any>
      get() = mapOf(
         "CURRENCY" to Currency.ARS,
         "DATE_FORMAT" to "dd/MM/yyyy"
         )
}