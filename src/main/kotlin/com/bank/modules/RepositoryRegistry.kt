package com.bank.modules

import com.bank.repository.CustomerRepository
import com.bank.repository.ExposedCustomerRepository
import com.bank.repository.MemCustomerRepository

object RepositoryRegistry {
    enum class Types {
        MEM, EXPOSED
    }

    const val paramKey = "repositry"

    var type: Types = Types.MEM

    val repository: CustomerRepository
        get() = when(type) {
            Types.MEM -> MemCustomerRepository()
            Types.EXPOSED -> {
                DBClient.init()
                ExposedCustomerRepository()
            }
        }


    fun setType(typeStr: String?) {
        type = Types.valueOf(typeStr?:"MEM")
    }
}