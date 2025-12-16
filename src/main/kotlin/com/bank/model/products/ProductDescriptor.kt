package com.bank.model.products

import com.swelms.common.locale.Locale
import com.swelms.common.reflection.qName
import com.swelms.common.serialization.serialName
import kotlin.reflect.KClass

class ProductDescriptor(val type: KClass<out Product>, val productId: String = type.serialName){
   val description: String get() = Locale.text(Product.qName, productId)
}
