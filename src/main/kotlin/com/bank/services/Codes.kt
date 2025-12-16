package com.bank.services

import com.bank.model.products.ActiveCurrencySet
import com.bank.model.products.Product
import com.bank.model.products.descriptor
import com.swelms.domain.person.Gender
import com.swelms.common.collections.*
import com.swelms.common.text.Case
import com.swelms.domain.id.card.CardBrand
import com.swelms.domain.id.cuit.*
import kotlin.collections.associate


object Codes: Catalog(Case.SNAKE) {
   init {
      init()
   }

   fun init(){
      put(Cuit.EntityType.entries.associateTo { it.description })
      put(Cuit.EntityCodes.associate { it.key to it.description })
      put(Product.types.associate { it.descriptor.typeId to it.descriptor.description  })
      put(Gender.entries.associateTo { it.description })
      put(CardBrand.entries.associateTo { it.description })
      put(ActiveCurrencySet.associateTo{ it.localeDescription})
   }
}

