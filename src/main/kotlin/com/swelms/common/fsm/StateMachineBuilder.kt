package com.swelms.common.fsm

fun <S> stateMachine(
   initialState: S,
   block: StateMachineBuilder<S>.() -> Unit
): StateMachine<S> =
   StateMachineBuilder(initialState).apply(block).build()

class StateMachineBuilder<S>(
   private val initialState: S
) {
   val GLOBAL = null as S?
   private val transitions = mutableListOf<Transition<S>>()

   fun state(state: S?, block: StateBuilder<S>.() -> Unit) {
      StateBuilder(state, transitions).block()
   }

   fun build(): StateMachine<S> =
      StateMachine(initialState, transitions)
}

class StateBuilder<S>(
   val state: S?,
   val transitions: MutableList<Transition<S>>
) {
   inline fun <reified E> transition(
      target: S,
      noinline guard: (E) -> Boolean = { true },
      noinline action: (E) -> Unit = {}
   ) {
      transitions += Transition(
         source = state,
         guard = { it is E && guard(it) },
         action = { if (it is E) action(it) },
         target = target
      )
   }
}

