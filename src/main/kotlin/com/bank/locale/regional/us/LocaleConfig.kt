package com.bank.locale.regional.us

import com.bank.model.products.structure.Currency
import com.sbarrasa.common.locale.AbstractRegionalConfig

object LocaleConfig: AbstractRegionalConfig() {
   override fun register() {
      register {
         it["CURRENCY"] = Currency.USD
         it["DATE_FORMAT"] = "MM-dd-yyyy"
      }
   }
}