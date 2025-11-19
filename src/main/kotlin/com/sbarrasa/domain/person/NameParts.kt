package com.sbarrasa.domain.person

import kotlinx.serialization.Serializable

@Serializable
data class NameParts(override val names: String,
                     override val lastNames: String?=null,
                     val validate: Boolean = true
): Nombrable{

   init {
      if (validate) {
         Name.validate(names)
         if (lastNames != null)
            Name.validate(lastNames)
      }

   }

   companion object{
      fun from(legalName: String, validate: Boolean = true): NameParts {
         val parts = legalName.split(",")

         return if(parts.size == 2)
            NameParts(names = parts[1].trim(), lastNames = parts[0].trim(), validate = validate)
         else
            NameParts(names = legalName, validate = validate)
      }
   }

}
