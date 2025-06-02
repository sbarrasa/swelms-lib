package com.bank.modules

import com.bank.repository.ExposedCustomerRepository
import com.bank.repository.MemCustomerRepository

object RepositoryFactory {
    enum class Types {
        MEM, EXPOSED
    }

    const val paramKey = "repo"

    var type: Types = Types.MEM

    fun create() = when(type) {
            Types.MEM -> MemCustomerRepository()
            Types.EXPOSED -> {
                DBClient.init()
                ExposedCustomerRepository()
            }
        }


    fun setType(typeStr: String?) {
        type = typeStr
            ?.let { Types.valueOf(it)}
            ?: Types.MEM

    }
}