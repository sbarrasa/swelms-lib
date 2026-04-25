package com.swelms.common.validator

import com.swelms.common.result.Result
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.test.assertFailsWith

class AggregateValidatorTest {
   data class User(val name: String, val age: Int)

   private val nameMessage = "El nombre no puede estar en blanco"
   private val ageLowMessage = "La edad debe ser mayor o igual a 18"
   private val ageUpMessage = "La edad no puede ser mayor que 100"

   val userValidator = AggregateValidator<User>(
      Rule(nameMessage) { it.name.isNotBlank() },
      Rule(ageLowMessage) { it.age >= 18 },
      Rule(ageUpMessage) { it.age <= 100 }
   )

   @Test
   fun validateSuccess() {
      val user = User("Juan", 30)
      assertEquals(user, userValidator.validate(user))
   }

   @Test
   fun validateFail() {
      val ex = assertFailsWith<AggregateException> {
         userValidator.validate(User("", 10))
      }

      assertEquals("$nameMessage; $ageLowMessage", ex.message)
   }

   @Test
   fun evaluateFail() {
      val result = userValidator.evaluate(User("", 10))
      assertTrue(result is Result.Fail)
      assertEquals("$nameMessage; $ageLowMessage", result.error.message)
   }

   @Test
   fun evaluateSuccess() {
      val user = User("Juan", 30)
      val result = userValidator.evaluate(user)
      assertTrue(result is Result.Success)
      assertEquals(user, result.value)
   }

   @Test
   fun evaluateAll() {
      val evaluations = userValidator.evaluateAll(User("", 10))
      assertEquals(3, evaluations.size)
      assertTrue(evaluations[0] is Result.Fail)
      assertTrue(evaluations[1] is Result.Fail)
      assertTrue(evaluations[2] is Result.Success)

   }

   @Test
   fun evaluateAllSuccess() {
      val user = User("Juan", 30)
      val evaluations = userValidator.evaluateAll(user)

      assertEquals(3, evaluations.size)
      assertTrue(evaluations.all { it is Result.Success })
      assertTrue(evaluations.all { it.value == user })
   }

   @Test
   fun evaluateAllMixed() {
      val user = User("Juan", 10)
      val evaluations = userValidator.evaluateAll(user)

      assertEquals(3, evaluations.size)
      assertTrue(evaluations[0] is Result.Success)
      assertEquals(user, evaluations[0].value)
      assertTrue(evaluations[1] is Result.Fail)
      assertEquals(ageLowMessage, (evaluations[1] as Result.Fail).error.message)
   }


   @Test
   fun messages() {
      val ex = assertFailsWith<AggregateException> {
         userValidator.validate(User("", 10))
      }
      assertEquals(listOf(nameMessage, ageLowMessage), ex.messages)
   }

   @Test
   fun evaluateFullRules() {
      val user = User("", 10)
      val evaluations = userValidator.evaluateAll(user)

      val maxFailsValidator = Validator<List<*>>(
         Rule("el maximo de errores es 2") { it.filterIsInstance<Result.Fail>().size <2 }
      )

      assertFailsWith<ValidatorException> { maxFailsValidator.validate(evaluations) }
   }

   @Test
   fun validatorOf(){
      val rule1 = Rule<Int>("muy joven") { it > 18 }
      val rule2 = Rule<Int>("muy viejo") { it > 100}

      val validator1 = validatorOf(rule1)
      val validator2 = validatorOf(rule1, rule2)

      assertTrue { validator1 is Validator }
      assertTrue { validator2 is AggregateValidator }
   }
}


