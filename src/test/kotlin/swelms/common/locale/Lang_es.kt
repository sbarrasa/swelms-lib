package swelms.common.locale

import swelms.common.reflection.property

val lang_es = Lang(locale_id = "es",
   "GENERAL" to "Este es un mensaje general",
   "TEST" to "Prueba",
   "NOT_IMPLEMENTED" to "Aún no está implementado",
   property<IntRange>("OUT_OF_RANGE") to "El valor debe estar entre {1} y {2}",
   "stock.NO_ITEMS" to "No hay artículos en stock"
)