package com.swelms.common.fsm

import kotlin.reflect.KClass

@Suppress("UNCHECKED_CAST")
data class Transition<S, E: Any>(
   val with: KClass<E>,
   val guard: (E) -> Boolean = { true },
   val from: S? = null,
   val to: S,
   val action: (E) -> Unit = {}
){
   constructor(
      with: KClass<E>,
      guard: (E) -> Boolean = { true },
      map: Pair<S?, S>,
      action: (E) -> Unit = {}
   ) : this(with, guard, map.first, map.second, action)


   fun guardCheck(e: Any) = guard(e as E)
}

