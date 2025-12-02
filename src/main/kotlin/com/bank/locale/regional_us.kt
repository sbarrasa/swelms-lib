package com.bank.locale

import com.swelms.common.locale.RegionalBuilder
import com.swelms.domain.locale.Currency

val regional_us = RegionalBuilder("us") {
   key["CURRENCY"] = Currency.USD
   key["DATE_FORMAT"] = "MM-dd-yyyy"
}