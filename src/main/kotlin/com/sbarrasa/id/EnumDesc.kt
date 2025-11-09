package com.sbarrasa.id

import kotlin.reflect.KClass

class EnumDesc<E>(val enumClass: KClass<E>) : IdDescMap
      where E : Enum<E>, E : Desc {

   override fun asMap(): Map<String, String> =
      enumClass.java.enumConstants.associate { (it as E).name to it.description }

   companion object {
      inline fun <reified E> of(): EnumDesc<E>
            where E : Enum<E>, E : Desc = EnumDesc(E::class)
   }

}