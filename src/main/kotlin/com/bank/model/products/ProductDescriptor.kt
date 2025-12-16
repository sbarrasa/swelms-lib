package com.bank.model.products

import com.swelms.common.locale.Locale
import com.swelms.common.reflection.qName

interface ProductDescriptor {
   val type: String
   val description: String get() = Locale.text(Product.qName, type)
}