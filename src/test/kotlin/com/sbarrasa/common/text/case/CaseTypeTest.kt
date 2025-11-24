package com.sbarrasa.common.text.case

import com.sbarrasa.common.text.Case
import com.sbarrasa.common.text.toCamelCase
import com.sbarrasa.common.text.toCase
import com.sbarrasa.common.text.toPascalCase
import com.sbarrasa.common.text.toSnakeCase
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
      assertEquals("CASECOVERSIONTEST", "CaseCoVersionTest".toCase(Case.UPPER))
      assertEquals("casecoversiontest", "CaseCoVersionTest".toCase(Case.LOWER))
   }

   @Test
   fun testToCaseDisPUTer() {
      val original = "CaseConversionTest"
      assertEquals("case_conversion_test", original.toCase(Case.SNAKE))
      assertEquals("caseConversionTest", "case_conversion_test".toCase(Case.CAMEL))
      assertEquals("CaseConversionTest", "case_conversion_test".toCase(Case.PASCAL))
      assertEquals("caseconversiontest", original.toCase(Case.LOWER))
      assertEquals("CASECONVERSIONTEST", original.toCase(Case.UPPER))
   }


}