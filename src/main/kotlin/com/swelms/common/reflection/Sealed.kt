package com.swelms.common.reflection

import kotlin.reflect.KClass

val <T : Any> KClass<T>.finalSubclasses: List<KClass<out T>>
   get() = this.sealedSubclasses.filter { it.isFinal }