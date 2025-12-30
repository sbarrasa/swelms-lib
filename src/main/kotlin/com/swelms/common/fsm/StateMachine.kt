package com.swelms.common.fsm

class StateMachine<S>(
   initialState: S,
   private val transitions: List<Transition<S>>
) {
   var state: S = initialState
      private set

   fun step(event: Any): S {
      val t = transitions.firstOrNull {
         it.source == null || it.source == state && it.guard(event)
      } ?: return state

      t.action(event)
      state = t.target
      return state
   }

   fun finalStates(): Set<S> {
      val sources = transitions.mapNotNull { it.source }.toSet()
      val targets = transitions.map { it.target }.toSet()
      return targets - sources
   }
}


