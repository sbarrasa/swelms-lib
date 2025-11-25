package com.swelms.domain.person

import com.swelms.domain.person.NameUtils.split

interface BasicFullName {
   val givenNames: NamePart
   val lastNames: NamePart

   companion object{
      fun create(fullNameText: String): BasicFullName {
         val parts = split(fullNameText)
         return object: BasicFullName {
            override val givenNames: NamePart
               get() = NamePart(parts[1].trim())
            override val lastNames: NamePart
               get() = NamePart(parts[0].trim())
         }
      }
   }
}