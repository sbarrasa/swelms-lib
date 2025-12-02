package com.swelms.common.locale

import com.swelms.common.reflection.qName

typealias LangBlock = MutableMap<String,String>.() -> Unit

open class LangBuilder(override val locale_id: String) : LangInterface {
   constructor(locale_id: String, block: LangBuilder.() -> Unit) : this(locale_id) {
      this.block()
   }
   override val moduleTextMap = mutableMapOf<String, MutableMap<String,String>>()

   val MutableMap<String,String>.key get() = this

   fun defaults(block: LangBlock) =
      module("default", block)

   inline fun <reified T> module(noinline block: LangBlock) =
      module(T::class.qName, block)

   fun module(name: String, block: LangBlock) {
      moduleTextMap[name] = mutableMapOf<String,String>().apply(block)
   }
}
