package com.bank.model.products

import com.swelms.common.reflection.finalSubclasses
import kotlinx.serialization.Serializable
import kotlin.reflect.KClass
import kotlin.reflect.full.companionObjectInstance
import kotlin.reflect.full.primaryConstructor

@Serializable
sealed interface Product {
   val description: String

   companion object {
      val types get() = Product::class.finalSubclasses

      inline fun <reified T : Product> create(map: Map<String, Any?>): T? {
         val constructor = T::class.primaryConstructor ?: return null
         val args = constructor.parameters.associateWith { map[it.name] }
         return constructor.callBy(args)
      }
   }

}

val KClass<out Product>.descriptor get() = this.companionObjectInstance as ProductDescriptor
