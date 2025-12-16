package com.bank.services

import com.bank.model.products.CheckingAccount
import com.bank.model.products.CreditCardProduct
import com.bank.model.products.DebitCardProduct
import com.bank.model.products.SavingAccount
import com.bank.model.products.Product
import com.bank.model.products.ProductDescriptor
import com.swelms.common.collections.Mappeable
import com.swelms.common.collections.ClassHierarchy
import kotlin.reflect.KClass
import kotlin.reflect.full.companionObjectInstance

object ProductTypes:
   ClassHierarchy<Product>(Product::class),
   Mappeable<String, String>
{
      init {
         with(subClasses){
            add(CheckingAccount::class)
            add(CreditCardProduct::class)
            add(DebitCardProduct::class)
            add(SavingAccount::class)
         }
      }

   @Suppress("UNCHECKED_CAST")
   fun getDescriptor(clazz: KClass<*>): ProductDescriptor? =
      clazz.companionObjectInstance as? ProductDescriptor


   override fun asMap(): Map<String, String> =
      subClasses.mapNotNull {
         clazz -> getDescriptor(clazz)
            ?.let { it.type to it.description }
      }.toMap()

}


