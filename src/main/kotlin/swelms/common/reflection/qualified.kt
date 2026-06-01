package swelms.common.reflection

import kotlin.jvm.java
import kotlin.reflect.KClass

val KClass<*>.packageName
   get() = java.packageName
val Any.packageName
   get() = this::class.packageName

val Any.qProperty get() = qProperty(toString())
fun Any.qProperty(name: String) =
   "${this.qName}.$name"

fun Any.qPackageProperty(name: String) =
   "$packageName.$name"

fun KClass<*>.qProperty(name: String) =
   "$qName.$name"

fun KClass<*>.qPackageProperty(name: String) =
   "$packageName.$name"

val Any.qName get() = this::class.qualifiedName?.removeSuffix("COMPANION")