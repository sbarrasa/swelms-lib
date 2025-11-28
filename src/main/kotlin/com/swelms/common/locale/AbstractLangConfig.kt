package com.swelms.common.locale

import kotlin.reflect.KClass


abstract class AbstractLangConfig: AbstractLocaleConfig() {
   val texts = mutableMapOf<String, MutableMap<String, String>>()

   private fun qualifiedName(k: KClass<*>): String {
      val q = k.qualifiedName ?: k.toString()
      return q.replaceSlots(".Companion", "")
   }

//TODO: implementar clave "default"
//TODO: implementar claves especiales String
   private fun textsForUpdate(k: String): MutableMap<String, String> =
      texts.getOrPut(k) { mutableMapOf() }

   private fun textsForUpdate(k: KClass<*>): MutableMap<String, String> =
      textsForUpdate(qualifiedName(k))

   fun texts(k: KClass<*>): Map<String, String>? = texts[qualifiedName(k)]

   fun forClass(k: KClass<*>, block: (MutableMap<String, String>) -> Unit) {
      val map = textsForUpdate(k)
      block(map)
   }

   inline fun <reified T : Any> forClass(noinline block: (MutableMap<String, String>) -> Unit) {
      forClass(T::class, block)
   }

   fun defaults(block: (MutableMap<String, String>) -> Unit) {
      val map = textsForUpdate(Any::class)
      block(map)
   }
   override fun unload() {
      texts.clear()
   }
}
