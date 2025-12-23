package com.swelms.common.text

import kotlin.test.Test
import kotlin.test.assertEquals

class CaseConversionTest {

   @Test
   fun upper() {
      assertEquals("SAMPLE MODEL", "sample model".toStyle(Style.UpperCase))
   }

   @Test
   fun lower(){
      assertEquals("sample model", "sample model".toStyle(Style.LowerCase))
   }

   @Test
   fun snake(){
      assertEquals("sample_model", "sample model".toStyle(Style.Snake))
   }

   @Test
   fun snakeUpper(){
      assertEquals("SAMPLE_MODEL", "sample model".toStyle(Style.Snake).toStyle(Style.UpperCase))
   }

   @Test
   fun pascal(){
      assertEquals("SampleModel", "sample model".toStyle(Style.Pascal))
   }

   @Test
   fun kebab(){
      assertEquals("sample-model", "sample model".toStyle(Style.Kebab))
   }

   @Test
   fun camel(){
      assertEquals("sampleModel", "sample model".toStyle(Style.Camel))
   }


   @Test
   fun dot(){
      assertEquals("sample.model", "sample model".toStyle(Style.Dot))
   }

   @Test
   fun custom(){
      val style = Style(words = Case.LOWER, joinChar = null)
      assertEquals("samplemodel", "SAMPLE MODEL".toStyle(style))
   }

   @Test
   fun customFirst(){
      val style = Style(words = Case.LOWER, capitalFirst = Case.UPPER)
      assertEquals("Sample model", "SAMPLE MODEL".toStyle(style))
   }

   @Test
   fun customDotInput(){
      val style = Style(splitChar = '.', capital = Case.UPPER, joinChar = null)
      assertEquals("SampleModel", "sample.model".toStyle(style))
   }

   @Test
   fun title(){
      assertEquals("Sample Model", "sample model".toStyle(Style.Title))
   }


}