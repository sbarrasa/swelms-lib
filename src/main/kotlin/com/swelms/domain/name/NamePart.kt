package com.swelms.domain.name

data class NamePart(override val text: String) : Names {
   init {
      Names.Companion.validate(text)
   }

   override fun toString(): String = text
}