package com.swelms.common.locale

import com.swelms.common.reflection.qName

open class LangBuilder(override val locale_id: String) : LangInterface {

   constructor(locale_id: String, block: LangBuilder.() -> Unit) : this(locale_id) {
      this.block()
   }

   override val textsByModule: MutableMap<String, MutableMap<String, String>> = mutableMapOf()

   fun default(block: (MutableMap<String, String>) -> Unit) {
      textsByModule["default"] = mutableMapOf<String, String>().also(block)
   }

   inline fun <reified T> module(block: (MutableMap<String, String>) -> Unit) {
      textsByModule[T::class.qName] = mutableMapOf<String, String>().also(block)
   }

   fun module(name: String, block: (MutableMap<String, String>) -> Unit) {
      textsByModule[name] = mutableMapOf<String, String>().also(block)
   }
}

