package com.sbarrasa.id

import com.sbarrasa.util.case.*
import kotlin.reflect.KClass
import kotlin.reflect.full.isSubclassOf

open class IdDescClassMap(items: List<Any>, keyCase: Case = Case.SNAKE)
   : Map<String, Map<String, String>> by buildMap(items, keyCase) {

   constructor(keyCase: Case = Case.SNAKE, vararg items: Any) : this(items.toList(), keyCase)

   companion object {
      private fun buildMap(items: List<Any>, keyCase: Case): Map<String, Map<String, String>> =
         items.associate { item ->
            val (key, map) = when (item) {
               is IdDescMap -> mapFromIdDescMap(item)
               is KClass<*> -> mapFromKClass(item)
               else -> error("Tipo no soportado: ${item::class.simpleName}")
            }
            key.toCase(keyCase) to map
         }

      private fun mapFromIdDescMap(item: IdDescMap): Pair<String, Map<String, String>> =
         item::class.simpleName!! to item.asMap()

      private fun mapFromKClass(kclass: KClass<*>): Pair<String, Map<String, String>> {
         require(kclass.isSubclassOf(Enum::class))
         require(Desc::class.java.isAssignableFrom(kclass.java))

         val enumConstants = kclass.java.enumConstants ?: throw IllegalArgumentException()

         val map = enumConstants
            .map { it as Enum<*> }
            .associate { it.name to (it as Desc).description }

         return kclass.simpleName!! to map
      }
   }
}
