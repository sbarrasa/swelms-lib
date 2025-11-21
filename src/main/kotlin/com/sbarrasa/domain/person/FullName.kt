package com.sbarrasa.domain.person

import kotlinx.serialization.Serializable

@JvmInline
@Serializable
value class FullName(override val text: String) : Name, BasicFullName  {
   init {
      NameUtils.validate(text, isFullName=true)
   }

   private val parts get() = BasicFullName.create(text)

   override val lastNames get() = parts.lastNames
   override val givenNames get() = parts.givenNames

   override val list: List<String> get() = givenNames.list + lastNames.list



}
