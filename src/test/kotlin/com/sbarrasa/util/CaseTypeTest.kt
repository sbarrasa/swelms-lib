package com.sbarrasa.util

import com.sbarrasa.util.Case.*
import kotlin.test.Test
import kotlin.test.assertEquals

class CaseConversionTest {

   @Test
   fun testToSnakeCase() {
      assertEquals("case_conversion_test", "CaseConversionTest".toSnakeCase())
   }

   @Test
   fun testToCamelCase() {
      assertEquals("caseConversionTest", "case_conversion_test".toCamelCase())
   }

   @Test
   fun testToPascalCase() {
      assertEquals("CaseConversionTest", "case_conversion_test".toPascalCase())
   }

   @Test
   fun testToUpperAndLower() {
      assertEquals("CASECOVERSIONTEST", "CaseCoVersionTest".toCase(UPPER))
      assertEquals("casecoversiontest", "CaseCoVersionTest".toCase(LOWER))
   }

   @Test
   fun testToCaseDispatcher() {
      val original = "CaseConversionTest"
      assertEquals("case_conversion_test", original.toCase(SNAKE))
      assertEquals("caseConversionTest", "case_conversion_test".toCase(CAMEL))
      assertEquals("CaseConversionTest", "case_conversion_test".toCase(PASCAL))
      assertEquals("caseconversiontest", original.toCase(LOWER))
      assertEquals("CASECONVERSIONTEST", original.toCase(UPPER))
   }

   @Test
   fun testKClassSimpleNameConversion() {
      assertEquals("case_conversion_test", CaseConversionTest::class.simpleName(SNAKE))
      assertEquals("CaseConversionTest", CaseConversionTest::class.simpleName(PASCAL))
      assertEquals("caseconversiontest", CaseConversionTest::class.simpleName(LOWER))
      assertEquals("CASECONVERSIONTEST", CaseConversionTest::class.simpleName(UPPER))
   }

   @Test
   fun testStringInterpolationWithSimpleName() {
      val expected = "ruta/case_conversion_test"
      val actual = "ruta/${CaseConversionTest::class.simpleName(SNAKE)}"
      assertEquals(expected, actual)
   }

}