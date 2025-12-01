package com.bank.locale

import com.swelms.common.locale.RegionalBuilder
import com.swelms.domain.locale.Currency

val regional_us = RegionalBuilder("us") {
   it["CURRENCY"] = Currency.USD
   it["DATE_FORMAT"] = "MM-dd-yyyy"
}