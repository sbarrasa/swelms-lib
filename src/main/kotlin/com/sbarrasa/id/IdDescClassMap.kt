package com.sbarrasa.id

import com.sbarrasa.util.case.*

open class IdDescClassMap(keyCase: Case = Case.SNAKE, classes: List<IdDescMap>)
   : Map<String, Map<String, String>> by buildMap(classes, keyCase) {

      constructor(keyCase: Case = Case.SNAKE, vararg classes: IdDescMap) : this(keyCase, classes.toList())

      companion object {
         private fun buildMap(classList: List<IdDescMap>, aCase: Case) =
            classList.associate {
               val key = when (it) {
                  is EnumDesc<*> -> it.enumClass.simpleName!!.toCase(aCase)
                  else -> it::class.simpleName!!.toCase(aCase)
               }
               key to it.asMap()
            }
      }
   }