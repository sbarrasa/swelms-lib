package com.swelms.common.validator

import com.swelms.common.type.ValResult
import kotlin.test.*
import com.swelms.domain.person.Gender
import com.swelms.domain.validator.DigitsValidator
import com.swelms.domain.validator.NotNullValidator

class ClassValidatorTest {
   @Test
   fun testListOf() {
      data class User(var gender: Gender, var age: Int, val code: String)


      val validations = ClassValidator(
         User::age mustBe { it < 51 },
         User::age mustBe { it > 18 },
         User::gender mustBe { it == Gender.M },
         User::code validatesWith DigitsValidator()
      )

      val users = listOf(
         User(Gender.M, 20, "123456789"),
         User(Gender.M, 51, "XXX"),
         User(Gender.F, 20, "4"),
         User(Gender.M, 20, "HOLA"),
         User(Gender.M, 17, "123456789")
      )

      assertNotNull(validations.validate(users[0]))
      assertFails { validations.validate(users[1])}
      assertFails { validations.validate(users[2])}
      assertFails { validations.validate(users[3])}
      assertFails { validations.validate(users[4])}

   }

   @Test
   fun evaluate(){

      data class User(var gender: Gender, var age: Int, val code: String)

      val validations = ClassValidator(
         User::gender mustBe { it == Gender.M },
         User::age mustBe { it < 51 },
         User::code validatesWith DigitsValidator()
      )

      val user = User(Gender.M, 60, "XXX")

      val results = validations.evaluate(user)

      println(results)

      assertTrue {  results[0] is ValResult.Success }
      assertTrue {  results[1] is ValResult.Error  }
      assertTrue {  results[2] is ValResult.Error  }

   }

   @Test
   fun nestedValidations() {
      data class Address(val street: String, val number: Int?=null)
      data class User(val name: String, val address: Address)

      val addressValidator = ClassValidator(
         Address::number validatesWith NotNullValidator()
      )

      val validations = ClassValidator(
         User::address validatesWith addressValidator,
         User::name mustBe { it.length > 3 }
      )

      val users = listOf(
         User("Maria", Address("Calle 123", 123)),
         User("Juan", Address("Calle 123")),
         User("Pe", Address("Calle 123", 1))
      )

      assertNotNull(validations.validate(users[0]))
      assertFails { validations.validate(users[1]) }
      assertFails { validations.validate(users[2]) }
   }

   @Test
   fun testOneProperty() {
      data class User(val name: String, val age: Int)
      val validator = User::age mustBe { it > 18 }

      assertFails { validator.validate(User("Juan", 17)) }
   }

}