package com.swelms.common.text

import kotlin.test.Test
import kotlin.test.assertEquals

class CaseConversionTest {

   @Test
   fun testToSnakeCase() {
      assertEquals("case_conversion_test", "CaseConversionTest".snakeCase())
   }

   @Test
   fun testToCamelCase() {
      assertEquals("caseConversionTest", "case_conversion_test".camelCase())
   }

   @Test
   fun testToPascalCase() {
      assertEquals("CaseConversionTest", "case_conversion_test".pascalCase())
   }

   @Test
   fun testToUpperAndLower() {
      assertEquals("CASECOVERSIONTEST", "CaseCoVersionTest".toCase(Case.UPPER))
      assertEquals("casecoversiontest", "CaseCoVersionTest".toCase(Case.LOWER))
   }

   @Test
   fun testToCaseDisPUTer() {
      val original = "CaseConversionTest"
      assertEquals("case_conversion_test", original.toCase(Case.SNAKE))
      assertEquals("CASE_CONVERSION_TEST", original.toCase(Case.UPPER_SNAKE))
      assertEquals("caseconversiontest", original.toCase(Case.LOWER))
      assertEquals("CASECONVERSIONTEST", original.toCase(Case.UPPER))
   }

   @Test
   fun testFromSnake() {
      val original = "case_conversion_test"
      assertEquals("caseConversionTest", original.toCase(Case.CAMEL))
      assertEquals("CaseConversionTest", original.toCase(Case.PASCAL))
      assertEquals("case_conversion_test", original.toCase(Case.LOWER))
      assertEquals("CASE_CONVERSION_TEST", original.toCase(Case.UPPER_SNAKE))
   }

   @Test
   fun sampleCase() {
      assertEquals("SAMPLE MODEL", Case.UPPER.sample)
      assertEquals("sample model", Case.LOWER.sample)
      assertEquals("sampleModel", Case.CAMEL.sample)
      assertEquals("SampleModel", Case.PASCAL.sample)
      assertEquals("sample_model", Case.SNAKE.sample)
      assertEquals("SAMPLE_MODEL", Case.UPPER_SNAKE.sample)
   }


}