package com.bank.model.products

import com.swelms.common.locale.Locale
import com.swelms.common.reflection.finalSubclasses
import com.swelms.common.reflection.qName
import com.swelms.common.serialization.serialName
import kotlin.reflect.KClass

class ProductDescriptor(val type: KClass<out Product>, val productId: String = type.serialName){
   val description: String get() = Locale.text(Product.qName, productId)

   companion object {
      val descriptors = Product::class.finalSubclasses.map { ProductDescriptor(it) }
      private val typesMap = descriptors.associateBy { it.type }
      private val idMap = descriptors.associateBy { it.productId }


      operator fun get(productId: String) =
         idMap[productId] ?: throw IllegalArgumentException("Product $productId not found")

      operator fun get(kclass: KClass<out Product>) =
         typesMap[kclass] ?: throw IllegalArgumentException("Product $kclass not found")
   }

}
