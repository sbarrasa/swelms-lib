package com.swelms.common.fsm

class StateMachine<S>(
   initialState: S,
   private val transitions: List<Transition<S, *>>
) {
   constructor(initialState: S, vararg transitions: Transition<S, *>)
         : this(initialState, transitions.toList())
   var state: S = initialState
      private set

   @Suppress("UNCHECKED_CAST")
   fun step(event: Any): S {
      val transition = transitions.firstOrNull {
               (it.from == null || it.from == state)
               && it.with.isInstance(event)
               && it.guardCheck(event)
      } ?: return state

      state = transition.to

      (transition.action as (Any) -> Unit)(event)
      return state
   }

   fun finalStates(): Set<S> {
      val sources = transitions.mapNotNull { it.from }.toSet()
      val targets = transitions.map { it.to }.toSet()
      return targets - sources
   }
}
