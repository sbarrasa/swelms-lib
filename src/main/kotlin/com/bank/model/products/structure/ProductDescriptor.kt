package com.bank.model.products.structure

import com.swelms.common.locale.Locale


interface ProductDescriptor {
   val type: String
   val description: String get() = Locale.text(Product.MODULE, type)
}