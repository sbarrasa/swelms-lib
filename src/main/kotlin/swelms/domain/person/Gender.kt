package swelms.domain.person

import swelms.common.locale.Locale
import swelms.common.reflection.qName

enum class Gender {
   M,
   F,
   X;

   val description: String
      get() = Locale.text(qName, name)
}