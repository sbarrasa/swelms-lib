package com.bank.product.registry

import com.bank.product.structure.ProductDescriptor
import com.bank.product.structure.Product
import com.sbarrasa.id.map.Mappeable
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.*
import kotlinx.serialization.modules.*
import kotlinx.serialization.serializer
import kotlin.reflect.KClass
import kotlin.reflect.full.companionObjectInstance


//TODO: generalizar comom un caso de repositorio
open class ProductRegistry: Mappeable<String, String> {
   private val classes = mutableMapOf<KClass<out Product>, KSerializer<out Product>>()

   @OptIn(InternalSerializationApi::class)
   fun register(clazz: KClass<out Product>) {
      classes[clazz] =  clazz.serializer()
   }

   val json: Json by lazy {
      Json {
         serializersModule = SerializersModule {
            polymorphic(Product::class) {
               classes.forEach { (clazz, serializer) ->
                  @Suppress("UNCHECKED_CAST")
                  subclass(clazz as KClass<Product>, serializer as KSerializer<Product>)
               }
            }
         }
         classDiscriminator = "id"
         ignoreUnknownKeys = true
      }
   }


   fun getDescriptor(clazz: KClass<out Product>) = clazz.companionObjectInstance as ProductDescriptor

   fun createFrom(jsonString: String): Product =
      json.decodeFromString(jsonString)

   fun createFrom(map: Map<String, Any>): Product {
      val jsonObject = JsonObject(map.mapValues { (_, v) -> JsonPrimitive(v.toString()) })
      return json.decodeFromJsonElement(jsonObject)
   }

   override fun asMap() = classes.keys.associate { clazz ->
      val descriptor = getDescriptor(clazz)
      descriptor.id to descriptor.description
   }
}