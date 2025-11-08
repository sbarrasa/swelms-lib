package com.sbarrasa.util.case

import kotlin.reflect.KClass

fun KClass<*>.simpleName(case: Case): String =
   simpleName!!.toCase(case)
