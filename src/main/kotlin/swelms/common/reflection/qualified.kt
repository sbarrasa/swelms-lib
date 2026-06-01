package swelms.common.reflection

import kotlin.jvm.java
import kotlin.reflect.KClass

val KClass<*>.packageName
   get() = java.packageName

val Any.packageName
   get() = this::class.packageName

val Enum<*>.qProperty
   get() = qProperty(name)
fun Any.qProperty(propertyName: String) = "$qName.$propertyName"

fun Any.qPackageProperty(propertyName: String) =
   "$packageName.$propertyName"

val Any.qName get() = this::class.qualifiedName?.removeSuffix("COMPANION")