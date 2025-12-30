package com.swelms.common.fsm

data class Transition<S>(
   val source: S? = null,
   val guard: (Any) -> Boolean = { true },
   val action: (Any) -> Unit = {},
   val target: S
)

