package swelms.common.locale

val lang_es = Lang(locale_id = "es"){
     defaults {
        it["GENERAL"] = "Este es un mensaje general"
        it["TEST"] = "Prueba"
        it["NOT_IMPLEMENTED"] = "Aún no está implementado"
     }

      module<IntRange> {
         it["OUT_OF_RANGE"] = "El valor debe estar entre {1} y {2}"
      }

      module("stock") {
         it["NO_ITEMS"] = "No hay artículos en stock"
      }
   }
