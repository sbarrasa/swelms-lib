package com.sbarrasa.util


fun <T> T.isValid(predicate: T.() -> Boolean): Boolean = predicate()

class Validator<T>(
    val exception: (String) -> Exception = { msg -> IllegalArgumentException(msg) },
    val message: (T) -> String = { "Invalid: $it" },
    val condition: T.() -> Boolean
) {
    fun validate(obj: T): Boolean {
        val valid = obj.isValid(condition)
        if(!valid)
            throw exception(message(obj))
        return valid
    }
}
