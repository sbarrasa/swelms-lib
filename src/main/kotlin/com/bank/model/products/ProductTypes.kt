package com.bank.model.products

import com.swelms.common.reflection.createFromMap
import com.swelms.common.reflection.finalSubclasses
import kotlin.reflect.KClass

object ProductTypes {
   private val typesMap = Product::class.finalSubclasses
      .associateWith { ProductDescriptor(it) }

   private val idMap = typesMap.values.associateBy { it.productId }

   val descriptors = typesMap.values

   operator fun get(productId: String) = idMap[productId] ?: throw IllegalArgumentException("Product $productId not found")

   operator fun get(kclass: KClass<out Product>) = typesMap[kclass] ?: throw IllegalArgumentException("Product $kclass not found")
}

