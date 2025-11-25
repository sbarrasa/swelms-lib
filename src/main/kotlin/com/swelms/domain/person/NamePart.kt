package com.swelms.domain.person


data class NamePart(override val text: String) : Names {
   init {
      Names.validate(text)
   }

   override fun toString(): String = text
}