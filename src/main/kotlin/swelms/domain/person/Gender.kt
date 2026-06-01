package swelms.domain.person

import swelms.common.locale.*
import swelms.common.reflection.qProperty

enum class Gender {
   M,
   F,
   X;
}

val Gender.localeDescription: String
      get() = Locale.textOrNull(qProperty) ?: name
