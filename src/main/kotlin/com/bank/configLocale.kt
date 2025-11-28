package com.bank

import com.bank.locale.*
import com.swelms.common.locale.Locale


fun configLocale() {
   val lang = System.getenv("lang")
   Locale.registerConfigs(LocaleConfig_us, LocaleConfig_ar, LocaleConfig_en, LocaleConfig_es )
   Locale.lang = lang
   println("lang=$Locale.lang")
}
