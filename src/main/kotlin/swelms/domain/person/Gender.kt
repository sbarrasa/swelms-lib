package swelms.domain.person

import swelms.common.locale.*

enum class Gender {
   M,
   F,
   X;

   val description: String
      get() = localeTextOrNull(name) ?: name
}