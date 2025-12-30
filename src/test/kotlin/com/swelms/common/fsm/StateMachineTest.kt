package com.swelms.common.fsm

import kotlin.test.*


class StateMachineDslTest {
   enum class OrderState { CREATED, VALIDATED, PAID, INVALID, CANCELLED }

   data class Account(val id: Int, var amount: Double = 100.0)

   data class Payment(val account: Account, val amount: Double)
   object Cancel

   val sm = stateMachine(initialState = OrderState.CREATED) {

         state(GLOBAL) {
            transition<Cancel>(OrderState.CANCELLED)
         }

         state(OrderState.CREATED) {
            transition<Account>(
               guard = { it.amount >= 100 },
               target = OrderState.VALIDATED,
            )
            transition<Account>(
               guard = { it.amount < 100 },
               target = OrderState.INVALID,
               action = { throw IllegalStateException("Invalid account") }
            )

         }

         state(OrderState.VALIDATED) {
            transition<Payment>(
               target = OrderState.PAID,
               guard = { it.amount > 0
                     && it.amount <= it.account.amount},
               action = { it.account.amount-= it.amount }
               )
         }
   }

   @Test
   fun full_happy_path() {
      val account = Account(1, 100.0)
      sm.step(account)
      assertEquals(OrderState.VALIDATED, sm.state)

      sm.step(Payment(account, 100.0))
      assertEquals(OrderState.PAID, sm.state)
   }

   @Test
   fun validation_blocks_payment() {
      val account = Account(1, 100.0)
      sm.step(account)
      sm.step(Payment(account, 10000.0))
      assertEquals(OrderState.VALIDATED, sm.state)
   }

   @Test
   fun invalidAccount() {
      val account = Account(1, 0.0)

      val e = assertFails { sm.step(account) }

      assertTrue(e is IllegalStateException)
      assertEquals(OrderState.INVALID, sm.state)
   }

   @Test
   fun cancel_from_any_state() {
      sm.step(Account(1))
      sm.step(Cancel)
      assertEquals(OrderState.CANCELLED, sm.state)
   }

   @Test
   fun ignored_event_does_not_change_state() {
      sm.step(Payment(Account(1), 50.0))
      assertEquals(OrderState.CREATED, sm.state)
   }

   @Test
   fun action_is_executed() {
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
      assertEquals(setOf(OrderState.PAID, OrderState.CANCELLED, OrderState.INVALID), sm.finalStates())
   }




}
