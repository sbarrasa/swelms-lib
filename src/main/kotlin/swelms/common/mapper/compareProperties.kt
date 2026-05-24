package swelms.common.mapper

import kotlin.reflect.KClass
import kotlin.reflect.KProperty1
import kotlin.reflect.full.declaredMemberProperties

fun <T : Any, U : Any> compareProperties(
   clazz1: KClass<T>,
   clazz2: KClass<U>
): List<Pair<KProperty1<T, *>, KProperty1<U, *>>> {
   val result = mutableListOf<Pair<KProperty1<T, *>, KProperty1<U, *>>>()
   val props2 = clazz2.declaredMemberProperties.associateBy { it.name }

   for (prop1 in clazz1.declaredMemberProperties) {
      val prop2 = props2[prop1.name]
      if (prop2 != null && prop1.returnType == prop2.returnType) {
         result.add(Pair(prop1, prop2))
      }
   }

   return result
}

inline fun <reified T : Any, reified U : Any> compareProperties() = compareProperties(T::class, U::class)
