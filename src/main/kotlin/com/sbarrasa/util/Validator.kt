package com.sbarrasa.util

fun <T> T.validate(
    exception: (String) -> Exception = { msg -> IllegalArgumentException(msg) },
    message: (T) -> String = { "Invalid: $it" },
    predicate: T.() -> Boolean
): Boolean {
    val valid = isValid(predicate)
    if(!valid)
        throw exception(message(this))
    return valid
}

fun <T> T.isValid(predicate: T.() -> Boolean): Boolean = predicate()

class Validator<T>(
    val exception: (String) -> Exception = { msg -> IllegalArgumentException(msg) },
    val message: (T) -> String = { "Invalid: $it" },
    val predicate: T.() -> Boolean
) {
    fun validate(obj: T): Boolean = obj.validate(exception, message, predicate)
}
