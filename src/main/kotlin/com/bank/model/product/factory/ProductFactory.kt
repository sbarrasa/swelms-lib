package com.bank.model.product.factory

import com.bank.model.product.Product
import com.bank.model.product.ProductHeader
import com.sbarrasa.id.IdDescMap


object ProductFactory : IdDescMap {
   private val creators = mutableMapOf<String, () -> Product>()

   fun <T : Product> register(
      header: ProductHeader? = null,
      creator: () -> T
   ) {
      val key = header?.id ?: creator().id
      creators[key] = creator
   }

   @Suppress("UNCHECKED_CAST")
   fun <T : Product> create(id: String): T =
      creators[id]?.invoke()?.let { it as T }
         ?: throw ProductTypeNotRegistered(id)

   override fun asMap(): Map<String, String> =
      creators.map { (key, creator) -> key to creator().description }.toMap()
}