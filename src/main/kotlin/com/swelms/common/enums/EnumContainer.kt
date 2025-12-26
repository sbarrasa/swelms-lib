package com.swelms.common.enums

import kotlin.reflect.KClass

interface EnumContainer<E : Enum<E>> {
   val enumClass: KClass<out E>
}