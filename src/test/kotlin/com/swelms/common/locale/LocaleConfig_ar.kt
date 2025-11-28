package com.swelms.common.locale


object LocaleConfig_ar : AbstractRegionalConfig() {
   override val locale_id = "ar"

   override fun onLoad() {
      values["CURRENCY"] = "ARS"
      values["DATE_FORMAT"] = "dd/MM/yyyy"
   }
}