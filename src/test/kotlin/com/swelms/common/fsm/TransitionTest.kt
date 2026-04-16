package com.swelms.common.fsm

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class TransitionTest {
   enum class State { A, B }
   data class Event(val value: Int)

   @Test
   fun guardCheck() {
      val transition = Transition(
         with = Event::class,
         guard = { it.value > 10 },
         from = State.A,
         to = State.B
      )

      assertFalse(transition.guardCheck(Event(10)))
      assertTrue(transition.guardCheck(Event(11)))
   }

   @Test
   fun pairConstructor() {
      val transition = Transition(
         with = Event::class,
         map = State.A to State.B
      )

      assertEquals(State.A, transition.from)
      assertEquals(State.B, transition.to)
   }

   @Test
   fun defaultGuard() {
      val transition = Transition(
         with = Event::class,
         from = null,
         to = State.B
      )

      assertTrue(transition.guardCheck(Event(-1)))
      assertTrue(transition.guardCheck(Event(0)))
      assertTrue(transition.guardCheck(Event(999)))
   }
}
