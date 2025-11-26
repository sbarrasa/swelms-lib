package com.swelms.domain.id.card

enum class CardBrand(val description: String) {
   VISA("VISA") ,
   MC("MasterCard"),
   MAESTRO("Maestro"),
   CABAL("Cabal"),
   AMEX("American Express"),
   DISCOVER("Discover"),
   DINERS("Diners Club");

   companion object {
      fun of(cardNumber: CardNumber) = BinTable.get(cardNumber.value)?.brand

   }
}
