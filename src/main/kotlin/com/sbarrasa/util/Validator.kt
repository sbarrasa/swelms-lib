package com.sbarrasa.util
fun <T> T.validate(vararg validators: T.() -> Boolean): Boolean {
    return validators.all { it() }
}

class Validator<T>(
    private vararg val validators: T.() -> Boolean,
    val onFailure: ((T) -> Exception)? = null
) {
    fun validate(obj: T): Boolean {
        val valid = obj.validate(*validators)
        if (!valid) onFailure?.let { throw it(obj) }
        return valid
    }
}
