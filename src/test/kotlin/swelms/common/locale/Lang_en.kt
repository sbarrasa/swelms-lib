package swelms.common.locale

import swelms.common.reflection.property

var lang_en = Lang(locale_id = "en",
         "GENERAL" to "This is a general message",
         "TEST" to "Test",
         "NOT_IMPLEMENTED" to "Not implemented yet",
         property<IntRange>("OUT_OF_RANGE") to "Value must be between {1} and {2}"
)
