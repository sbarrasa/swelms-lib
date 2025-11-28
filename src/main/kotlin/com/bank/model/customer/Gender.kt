package com.bank.model.customer

import com.swelms.common.locale.Locale

enum class Gender() {
   M,
   F,
   X;

   val description: String
      get() = Locale.text(this::class, name)
}

