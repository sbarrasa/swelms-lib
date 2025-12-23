package com.swelms.common.serialization

import com.swelms.common.reflection.finalSubclasses
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.SerializationException
import kotlinx.serialization.modules.SerializersModuleBuilder
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.serializer
import kotlin.reflect.KClass

@OptIn(InternalSerializationApi::class)
fun <B : Any> SerializersModuleBuilder.polymorphic(sealedClass: KClass<B>) =
   polymorphic(sealedClass, sealedClass.finalSubclasses)


@OptIn(InternalSerializationApi::class)
fun <B : Any> SerializersModuleBuilder.polymorphic(
   baseClass: KClass<B>,
   subclasses: List<KClass<out B>>
) {
   polymorphic(baseClass) {
      subclasses.forEach { subclass ->
         @Suppress("UNCHECKED_CAST")
         try {
            subclass(subclass as KClass<B>, subclass.serializer())
         } catch (_: SerializationException) { }
      }
   }
}
