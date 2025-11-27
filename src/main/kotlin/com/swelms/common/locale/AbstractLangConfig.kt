package com.swelms.common.locale

import kotlin.reflect.KClass


abstract class AbstractLangConfig: AbstractLocaleConfig {
   val classTextsMap = mutableMapOf<String, MutableMap<String, String>>()

   private fun qualifiedName(k: KClass<*>): String {
      val q = k.qualifiedName ?: k.toString()
      return q.replace(".Companion", "")
   }

   private fun getTextsForUpdate(k: KClass<*>): MutableMap<String, String> {
      return classTextsMap.getOrPut(qualifiedName(k)) { mutableMapOf() }
   }

   fun getTexts(k: KClass<*>): Map<String, String>? = classTextsMap[qualifiedName(k)]

   fun texts(k: KClass<*>, block: (MutableMap<String, String>) -> Unit) {
      val map = getTextsForUpdate(k)
      block(map)
   }

   inline fun <reified T : Any> texts(noinline block: (MutableMap<String, String>) -> Unit) {
      texts(T::class, block)
   }

   fun defaults(block: (MutableMap<String, String>) -> Unit) {
      val map = getTextsForUpdate(Any::class)
      block(map)
   }

}
