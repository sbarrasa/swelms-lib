package com.bank.locale.regional.ar

import com.bank.model.products.structure.Currency
import com.swelms.common.locale.AbstractRegionalConfig

object LocaleConfig: AbstractRegionalConfig() {
   override fun register() {
      register {
         it["CURRENCY"] = Currency.ARS
         it["DATE_FORMAT"] = "dd/MM/yyyy"
      }
   }
}