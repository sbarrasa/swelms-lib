package com.bank.model.product.factory

import com.bank.model.product.Product
import com.sbarrasa.util.id.IdDescMap


typealias ProductCreator<T> = () -> T

object ProductTypes : IdDescMap {
   private val creators = HashMap<String, ProductCreator<out Product>>()

   fun register(productRegister: ProductRegister<out Product>) =
      register(productRegister.id, productRegister.creator)

   fun <T : Product> register(productType: String, creator: ProductCreator<T>): ProductTypes {
      creators[productType] = creator
      return this
   }

   @Suppress("UNCHECKED_CAST")
   fun <T : Product> create(productType: String): T {
      val creator = creators[productType]
         ?: throw ProductTypeNotRegistered(productType)
      return creator.invoke() as T
   }

   override fun asMap() =
      creators.mapValues { it.value().description }


}