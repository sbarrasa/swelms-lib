package com.bank.locale

import com.bank.model.products.structure.Currency
import com.swelms.common.locale.AbstractRegionalConfig
import kotlin.collections.set

object LocaleConfig_us: AbstractRegionalConfig() {
   override val key = "us"

   override fun onLoad() {
      values["CURRENCY"] = Currency.USD
      values["DATE_FORMAT"] = "MM-dd-yyyy"
   }
}