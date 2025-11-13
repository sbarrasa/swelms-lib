package com.bank.dto.product.factory

import com.bank.dto.product.Product
import com.bank.dto.product.ProductHeader
import com.sbarrasa.util.map.Mappeable

object ProductFactory: Mappeable<String, String> {
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