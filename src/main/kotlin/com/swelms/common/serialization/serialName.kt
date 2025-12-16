package com.swelms.common.serialization

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.serializer
import kotlin.reflect.KClass

@OptIn(ExperimentalSerializationApi::class)
val <T : Any> KClass<T>.serialName get() =
   serializer(this, emptyList(), isNullable = false).descriptor.serialName
