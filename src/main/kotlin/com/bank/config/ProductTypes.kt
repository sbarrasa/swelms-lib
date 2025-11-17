package com.bank.config

import com.bank.dto.product.Product
import com.bank.dto.product.types.CheckingAccount
import com.bank.dto.product.types.CreditCard
import com.bank.dto.product.types.DebitCard
import com.bank.dto.product.types.SavingAccount
import com.sbarrasa.id.map.Mappeable
import com.sbarrasa.registry.Registry

//TODO: cambiar lógica para registrar prototipos de producto que permitan luego copiar / instanciar vía copia
object ProductTypes: Registry<String, Product>(), Mappeable<String, String> {
   init {
      register(SavingAccount.id) { SavingAccount()}
      register(CheckingAccount.id) { CheckingAccount()}
      register(CreditCard.id) {CreditCard()}
      register(DebitCard.id) {DebitCard()}
   }
   override fun asMap(): Map<String, String> =
      constructors.keys.associate { it to create(it).description }
}