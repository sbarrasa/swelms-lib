package com.swelms.common.locale.regional.ar

import com.swelms.common.locale.AbstractRegionalConfig
import java.time.format.DateTimeFormatter

object LocaleConfig : AbstractRegionalConfig() {
   override fun register() {
      register("CURRENCY", "ARS")
      register("DATE_FORMATTER", DateTimeFormatter.ofPattern("dd/MM/yyyy"))
   }
}