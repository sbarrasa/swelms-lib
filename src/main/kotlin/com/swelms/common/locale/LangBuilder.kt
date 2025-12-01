package com.swelms.common.locale

import com.swelms.common.reflection.qName

class LangBuilder(localeId: String, block: LangBuilder.() -> Unit) : AbstractLangConfig {
   override val locale_id = localeId
   override val textsByModule: MutableMap<String, MutableMap<String, String>> = mutableMapOf()

   init {
      block()
   }

   fun default(block: (MutableMap<String, String>) -> Unit) {
      textsByModule.getOrPut("default") { mutableMapOf() }.also(block)
   }

   inline fun <reified T> module(block: (MutableMap<String, String>) -> Unit) {
      textsByModule.getOrPut(T::class.qName) { mutableMapOf() }.also(block)
   }

   fun module(name: String, block: (MutableMap<String, String>) -> Unit) {
      textsByModule.getOrPut(name) { mutableMapOf() }.also(block)
   }

}
