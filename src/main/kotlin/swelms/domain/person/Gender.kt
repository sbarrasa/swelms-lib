package swelms.domain.person

import swelms.common.locale.*

enum class Gender {
   M,
   F,
   X;
}

val Gender.localeDescription: String
      get() = Locale.textOrNull("Gender.${name}.description") ?: name
