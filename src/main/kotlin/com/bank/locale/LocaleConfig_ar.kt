package com.bank.locale

import com.bank.model.products.structure.Currency
import com.swelms.common.locale.AbstractRegionalConfig

object LocaleConfig_ar: AbstractRegionalConfig {
   override val locale_id = "ar"

   override val valueMap: Map<String, Any>
      get() = mapOf(
         "CURRENCY" to Currency.ARS,
         "DATE_FORMAT" to "dd/MM/yyyy"
         )
}