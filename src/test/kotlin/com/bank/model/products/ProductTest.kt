package com.bank.model.products

import com.bank.locale.lang_en
import com.bank.locale.lang_es
import com.swelms.common.locale.Locale
import kotlin.reflect.full.companionObjectInstance
import kotlin.test.Test


class ProductTest {
   init {
      Locale.registerConfigs(lang_es, lang_en)
      Locale.lang = "es"
   }

   @Test
   fun listProducts() {
      Product.types.forEach {
        val descriptor = it.companionObjectInstance as? ProductDescriptor
         with(descriptor!!){
            println("$type: $description")
         }
      }
   }
}