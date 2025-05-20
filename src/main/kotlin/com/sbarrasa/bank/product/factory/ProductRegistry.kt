package com.sbarrasa.bank.product.factory

import com.sbarrasa.bank.product.Product


typealias ProductCreator<T> = () -> T

object ProductRegistry {
    private val creators = HashMap<String, ProductCreator<out Product>>()

    fun <T : Product> register(productRegister: ProductRegister<T>) =
        register(productRegister.productType, productRegister.creator)


    fun <T : Product> register(productType: String, creator: ProductCreator<T>): ProductRegistry {
        creators[productType] = creator
        return this
    }

    @Suppress("UNCHECKED_CAST")
    fun <T : Product> create(productType: String): T {
        val creator = creators[productType]
            ?: throw ProductTypeNotRegistered(productType)
        return creator.invoke() as T
    }
}