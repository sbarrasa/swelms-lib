package com.bank.model.products

import com.swelms.common.reflection.*
import com.swelms.common.serialization.serialName
import kotlinx.serialization.Serializable
import kotlin.reflect.KClass
import kotlin.reflect.full.companionObjectInstance

@Serializable
sealed interface Product {
   val description: String

   val descriptor get() = ProductDescriptor[this::class]
}
