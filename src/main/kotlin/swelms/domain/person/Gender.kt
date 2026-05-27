package swelms.domain.person

import swelms.common.locale.*
import swelms.common.reflection.qName

enum class Gender {
   M,
   F,
   X;

   val description: String
      get() = LocaleContext.default.text(qName, name)
}