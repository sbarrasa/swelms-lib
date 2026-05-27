package swelms.common.locale

import swelms.domain.locale.Currency

val regional_ar = Regional(locale_id = "ar"){
   it["CURRENCY"] = Currency.ARS
   it["DATE_FORMAT"] = "dd/MM/yyyy"
}
