package com.bank

import com.bank.locale.*
import com.swelms.common.locale.Locale


fun configLocale() {
   val lang = System.getenv("lang")
   Locale.registerConfigs(regional_us, regional_ar, lang_en, lang_es )
   Locale.lang = lang
   println("lang=${Locale.lang}")
}
