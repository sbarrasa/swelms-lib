package com.sbarrasa.person

import kotlinx.serialization.Serializable

@Serializable(with = NameAsStringSerializer::class)
data class Name (
   val nameList: MutableList<String> = mutableListOf(),
   val lastNameList: MutableList<String> = mutableListOf()
): Nombrable {

   constructor(names: String, lastNames: String): this() {
      nameList.addAll(split(names))
      lastNameList.addAll(split(lastNames))
   }

   constructor(legalName: String) : this(
      names = legalName.substringAfter(",", "").trim(),
      lastNames = legalName.substringBefore(",", "").trim(',')
   )

   private fun split(value: String) = value.trim().split("\\s+".toRegex()).filter { it.isNotBlank() }

   private val fullNameList get() = nameList + lastNameList

   val size: Int
      get() = nameList.size + lastNameList.size

   operator fun get(index: Int) = fullNameList[index]

   fun fullNameFormat() = "$names $lastNames".trim()
   fun legalNameFormat() = "$lastNames, $names".trim().trimEnd(',')

   override val names get() = nameList.joinToString(" ")
   override val lastNames get() = lastNameList.joinToString(" ")

   override fun toString() =fullNameFormat()

}