package com.sbarrasa.util.id

interface EnumDescMap<E> : IdDescMap where E : Enum<E>, E : Desc {
   val values: List<E>
   override fun asMap() = values.associate { it.name to it.description }
}