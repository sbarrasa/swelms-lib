package com.sbarrasa.registry

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.*
import kotlinx.serialization.modules.*
import kotlinx.serialization.serializer
import kotlin.reflect.KClass


open class PolymorphicJsonRegistry<B : Any>(private val base: KClass<B>) {

   val classes = mutableMapOf<KClass<out B>, KSerializer<out B>>()

   @OptIn(InternalSerializationApi::class)
   fun register(clazz: KClass<out B>) {
      classes[clazz] = clazz.serializer()
   }

   val json by lazy {
      Json {
         serializersModule = SerializersModule {
            polymorphic(base) {
               classes.forEach { (clazz, serializer) ->
                  @Suppress("UNCHECKED_CAST")
                  subclass(
                     clazz as KClass<B>,
                     serializer as KSerializer<B>
                  )
               }
            }
         }
         classDiscriminator = "id"
         ignoreUnknownKeys = true
      }
   }

}

inline fun <reified T> Json.decodeFromMap(map: Map<String, Any>): T {
   val jsonObject = JsonObject(
      map.mapValues { (_, v) -> JsonPrimitive(v.toString()) }
   )
   return decodeFromJsonElement(jsonObject)
}