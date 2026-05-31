package swelms.common.reflection

import kotlin.jvm.java


val Any.packageName get() = this::class.java.packageName

fun Any.property(name: String) = "${this::class.simpleName}.$name"

fun Any.component(name: String) = "${this.packageName}.$name"

inline fun <reified T> property(name: String) = "${T::class.simpleName}.$name"

inline fun <reified T> component(name: String) = "${T::class.java.packageName}.$name"
