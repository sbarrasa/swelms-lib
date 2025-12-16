package com.bank.model.products

import com.bank.model.products.Product

sealed interface CreditProduct {
   val creditLimit: Double
}