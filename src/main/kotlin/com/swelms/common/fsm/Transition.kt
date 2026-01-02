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
      trans: Pair<S?, S>,
      action: (E) -> Unit = {}
   ) : this(with, guard, trans.first, trans.second, action)


   fun guardCheck(e: Any) = guard(e as E)
}

