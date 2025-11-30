package com.swelms.domain.person

import com.swelms.common.locale.Locale
import com.swelms.common.reflection.qName

enum class Gender() {
   M,
   F,
   X;

   val description: String
      get() = Locale.text(qName, name)
}