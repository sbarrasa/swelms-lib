package swelms.common.mapper

import kotlin.reflect.KMutableProperty1

fun <T: Any> T.copyFrom(source: Any): T {
   val matchingProperties = compareProperties(source::class, this::class)

   for (pair in matchingProperties) {
      val sourceProp = pair.first
      val targetProp = pair.second

      if (targetProp is KMutableProperty1) {
         val value = sourceProp.getter.call(source)

         @Suppress("UNCHECKED_CAST")
         val mutableTargetProp = targetProp as KMutableProperty1<Any, Any?>
         mutableTargetProp.set(this, value)
      }
   }

   return this
}
fun <S: Any, T : Any> T.copyFrom(
   source: S,
   block: (T.(S) -> Unit)?
): T {
   copyFrom(source)

   return applyFrom(source, block)
}

fun <S: Any, T : Any> T.applyFrom(
   source: S,
   block: (T.(S) -> Unit)?
): T {
   block?.invoke(this, source)
   return this
}

