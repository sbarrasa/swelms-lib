package com.bank.services

import com.bank.model.products.CheckingAccount
import com.bank.model.products.CreditCard
import com.bank.model.products.DebitCard
import com.bank.model.products.SavingAccount
import com.sbarrasa.registry.PolymorphicJsonRegistry
import com.bank.model.products.structure.Product
import com.bank.model.products.structure.ProductDescriptor
import com.sbarrasa.id.map.Mappeable
import kotlin.reflect.KClass
import kotlin.reflect.full.companionObjectInstance

object ProductTypes : PolymorphicJsonRegistry<Product>(Product::class), Mappeable<String, String>{

   @Suppress("UNCHECKED_CAST")
   fun getDescriptor(clazz: KClass<*>): ProductDescriptor? =
      clazz.companionObjectInstance as? ProductDescriptor


   override fun asMap(): Map<String, String> {
      return classes.keys
         .mapNotNull { k -> getDescriptor(k)?.let { d -> d.id to d.description } }.toMap()
   }

   init {
      register(CheckingAccount::class)
      register( SavingAccount::class)
      register(CreditCard::class)
      register( DebitCard::class)
   }
}