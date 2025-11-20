package com.sbarrasa.domain.person

import com.sbarrasa.domain.person.NameUtils.split

interface SimpleFullName {
   val givenNames: NamePart
   val lastNames: NamePart

   companion object{
      fun create(fullNameText: String): SimpleFullName {
         val parts = split(fullNameText)
         return object: SimpleFullName {
            override val givenNames: NamePart
               get() = NamePart(parts[1].trim())
            override val lastNames: NamePart
               get() = NamePart(parts[0].trim())
         }
      }
   }
}