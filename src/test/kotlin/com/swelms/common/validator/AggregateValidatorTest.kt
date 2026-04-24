package com.swelms.common.validator

import com.swelms.common.result.Result
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.test.assertFailsWith

class AggregateValidatorTest {
   data class User(val name: String, val age: Int)
   @Test
   fun validateSuccess() {
      val validator = AggregateValidator<User>(
         Rule("name blank") { it.name.isNotBlank() },
         Rule("age < 18") { it.age >= 18 }
      )

      val user = User("Juan", 30)
      assertEquals(user, validator.validate(user))
   }

   @Test
   fun validateFail() {
      val validator = AggregateValidator<User>(
         Rule("name blank") { it.name.isNotBlank() },
         Rule("age < 18") { it.age >= 18 }
      )

      val ex = assertFailsWith<AggregateException> {
         validator.validate(User("", 10))
      }

      assertEquals("name blank; age < 18", ex.message)
   }

   @Test
   fun evaluateFail() {
      val validator = AggregateValidator<User>(
         Rule("name blank") { it.name.isNotBlank() },
         Rule("age < 18") { it.age >= 18 }
      )

      val result = validator.evaluate(User("", 10))
      assertTrue(result is Result.Fail)
      assertEquals("name blank; age < 18", result.error.message)
   }

   @Test
   fun evaluateSuccess() {
      val validator = AggregateValidator<User>(
         Rule("name blank") { it.name.isNotBlank() },
         Rule("age < 18") { it.age >= 18 }
      )

      val user = User("Juan", 30)
      val result = validator.evaluate(user)
      assertTrue(result is Result.Success)
      assertEquals(user, result.value)
   }

   @Test
   fun evaluateAllFail() {
      val validator = AggregateValidator<User>(
         Rule("name blank") { it.name.isNotBlank() },
         Rule("age < 18") { it.age >= 18 }
      )

      val all = validator.evaluateAll(User("", 10))
      assertEquals(2, all.size)
      assertTrue(all.all { it is Result.Fail })
   }

   @Test
   fun evaluateAllSuccess() {
      val validator = AggregateValidator<User>(
         Rule("name blank") { it.name.isNotBlank() },
         Rule("age < 18") { it.age >= 18 }
      )

      val user = User("Juan", 30)
      val all = validator.evaluateAll(user)

      assertEquals(2, all.size)
      assertTrue(all.all { it is Result.Success })
      assertTrue(all.all { it.value == user })
   }

   @Test
   fun evaluateAllMixed() {
      val validator = AggregateValidator<User>(
         Rule("name blank") { it.name.isNotBlank() },
         Rule("age < 18") { it.age >= 18 }
      )

      val user = User("Juan", 10)
      val all = validator.evaluateAll(user)

      assertEquals(2, all.size)
      assertTrue(all[0] is Result.Success)
      assertEquals(user, all[0].value)
      assertTrue(all[1] is Result.Fail)
      assertEquals("age < 18", (all[1] as Result.Fail).error.message)
   }

   @Test
   fun messages() {
      val validator = AggregateValidator<User>(
         Rule("name blank") { it.name.isNotBlank() },
         Rule("age < 18") { it.age >= 18 }
      )

      val ex = assertFailsWith<AggregateException> {
         validator.validate(User("", 10))
      }

      assertEquals(listOf("name blank", "age < 18"), ex.messages)
   }
}
