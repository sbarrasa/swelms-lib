package com.swelms.common.locale

object LocaleConfig_en : AbstractLangConfig() {
   override val key = "en"

   override fun onLoad() {
      defaults {
         it["GENERAL"] = "This is a general message"
      }

      forClass<Any> {
         it["TEST"] = "Test"
         it["NOT_IMPLEMENTED"] = "Not implemented yet"
      }

      forClass<IntRange> {
         it["OUT_OF_RANGE"] = "Value must be between {1} and {2}"
      }
   }
}
