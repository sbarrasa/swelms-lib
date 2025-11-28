package com.bank.locale

import com.bank.model.products.structure.Currency
import com.swelms.common.locale.AbstractRegionalConfig

object LocaleConfig_ar: AbstractRegionalConfig() {
   override val key = "ar"

   override fun onLoad() {
      values["CURRENCY"] = Currency.ARS
      values["DATE_FORMAT"] = "dd/MM/yyyy"
   }
}