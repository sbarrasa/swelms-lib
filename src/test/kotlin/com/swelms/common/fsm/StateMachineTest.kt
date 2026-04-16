package com.swelms.common.fsm

import kotlin.test.*
class StateMachineTest {
   enum class OrderState { CREATED, VALIDATED, PAID, INVALID, REJECTED, CANCELLED }
   data class Account(val id: Int, var amount: Double = 100.0)
   data class Payment(val account: Account, val amount: Double)
   object Cancel

   private fun stateMachine() = StateMachine(OrderState.CREATED,
      Transition(
         Cancel::class,
         to = OrderState.CANCELLED
      ),
      Transition(Account::class,
         guard = { it.amount >= 100.0 },
         OrderState.CREATED to OrderState.VALIDATED
      ),
      Transition(Account::class,
         guard = { it.amount < 100.0 },
         OrderState.CREATED to OrderState.INVALID,
         action = { throw IllegalStateException("Invalid account") },
      ),
      Transition(Payment::class,
         guard = { it.amount > 0 && it.amount <= it.account.amount },
         OrderState.VALIDATED to OrderState.PAID,
         action = { it.account.amount -= it.amount }
      ),
      Transition(Payment::class,
         guard = { it.amount > 0 && it.amount > it.account.amount },
         map = OrderState.VALIDATED to OrderState.REJECTED
      )
   )

   @Test
   fun happyPath() {
      val sm = stateMachine()
      val account = Account(1, 100.0)
      sm.step(account)
      assertEquals(OrderState.VALIDATED, sm.state)

      sm.step(Payment(account, 100.0))
      assertEquals(OrderState.PAID, sm.state)
   }

   @Test
   fun blockedPayment() {
      val sm = stateMachine()
      val account = Account(1, 100.0)
      sm.step(account)
      sm.step(Payment(account, 10000.0))
      assertEquals(OrderState.REJECTED, sm.state)
   }

   @Test
   fun invalidAccount() {
      val sm = stateMachine()
      val account = Account(1, 0.0)

      val e = assertFails { sm.step(account) }

      assertTrue(e is IllegalStateException)
      assertEquals(OrderState.INVALID, sm.state)
   }

   @Test
   fun cancelAnyState() {
      val sm = stateMachine()
      sm.step(Account(1))
      sm.step(Cancel)
      assertEquals(OrderState.CANCELLED, sm.state)
   }

   @Test
   fun ignoredEvent() {
      val sm = stateMachine()
      sm.step(Payment(Account(1), 50.0))
      assertEquals(OrderState.CREATED, sm.state)
   }

   @Test
   fun actionExecuted() {
      val sm = stateMachine()
      assertEquals(OrderState.CREATED, sm.state)

      val account = Account(1, 1000.0)

      sm.step(account)
      assertEquals(OrderState.VALIDATED, sm.state)

      sm.step(Payment(account, 250.0))

      assertEquals(750.0, account.amount)
      assertEquals(OrderState.PAID, sm.state)
   }

   @Test
   fun finalStates(){
      val sm = stateMachine()
      assertEquals(setOf(OrderState.PAID, OrderState.CANCELLED, OrderState.INVALID, OrderState.REJECTED), sm.finalStates())
   }
}
