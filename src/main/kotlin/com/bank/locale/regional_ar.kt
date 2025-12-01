package com.bank.locale

import com.swelms.common.locale.RegionalBuilder
import com.swelms.domain.locale.Currency

val regional_ar = RegionalBuilder("ar") {
   it["CURRENCY"] = Currency.ARS
   it["DATE_FORMAT"] = "dd/MM/yyyy"
}
