package com.sbarrasa.domain.person

import kotlinx.serialization.Serializable

@Serializable
data class FullName(override val names: String,
                    override val lastNames: String?=null,
                    private val validate: Boolean = true
): Nombrable{

   init {
      if (validate) {
         NameUtils.validate(names)
         if (lastNames != null)
            NameUtils.validate(lastNames)
      }

   }

   companion object{
      fun from(legalName: String, validate: Boolean = true): FullName {
         val parts = legalName.split(",")

         return if(parts.size == 2)
            FullName(names = parts[1].trim(), lastNames = parts[0].trim(), validate = validate)
         else
            FullName(names = legalName, validate = validate)
      }
   }
   val nameList by lazy { names.split(" ")}

   val lastNameList by lazy { lastNames?.split(" ") ?: emptyList() }

   val fullNameList get() = nameList + lastNameList

   val count: Int get() = fullNameList.size

   operator fun get(index: Int) = fullNameList[index]


}
