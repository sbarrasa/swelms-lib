package com.sbarrasa.util.id

import com.sbarrasa.util.Case
import com.sbarrasa.util.simpleName

open class CodesClassMap(classes: List<IdDescMap>, keyCase: Case = Case.SNAKE)
   : Map<String, Map<String, String>> by buildMap(classes, keyCase) {
   companion object {
      private fun buildMap(classList: List<IdDescMap>, aCase: Case) =
         classList.associate {
            val key = it.javaClass.enclosingClass?.kotlin?.simpleName(aCase)
               ?: it::class.simpleName(aCase)
            key to it.asMap()
         }
   }
}