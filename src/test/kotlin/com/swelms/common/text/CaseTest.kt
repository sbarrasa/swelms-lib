package com.swelms.common.text

import kotlin.test.Test
import kotlin.test.assertEquals

class CaseConversionTest {

   @Test
   fun upper() {
      assertEquals("SAMPLE MODEL", "sample model".toStyle(Style.UPPERCASE))
   }

   @Test
   fun lower(){
      assertEquals("sample model", "sample model".toStyle(Style.LOWERCASE))
   }

   @Test
   fun snake(){
      assertEquals("sample_model", "sample model".toStyle(Style.SNAKE))
   }

   @Test
   fun snakeUpper(){
      val style = Style.SNAKE.copy(words = Case.UPPER)
      assertEquals("SAMPLE_MODEL", "sample model".toStyle(style))
   }

   @Test
   fun pascal(){
      assertEquals("SampleModel", "sample model".toStyle(Style.PASCAL))
   }

   @Test
   fun kebab(){
      assertEquals("sample-model", "sample model".toStyle(Style.KEBAB))
   }

   @Test
   fun camel(){
      assertEquals("sampleModel", "sample model".toStyle(Style.CAMEL))
   }


   @Test
   fun dot(){
      assertEquals("sample.model", "sample model".toStyle(Style.DOT))
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
      assertEquals("Sample Model", "sample model".toStyle(Style.TITLE))
   }

   @Test
   fun dotToPath(){
      val style = Style.unixPath from Style.DOT
      assertEquals("com/swelms/text", "com.swelms.text".toStyle(style))
   }

   @Test
   fun unixToWindowsPath(){
      val style = Style.windowsPath from Style.unixPath
      assertEquals("com\\swelms\\text", "com/swelms/text".toStyle(style))
   }

   @Test
   fun snakeToCamel(){
      val style = Style.CAMEL from Style.SNAKE
      assertEquals("sampleModel", "sample_model".toStyle(style))
   }

   @Test
   fun pascalFromCamel(){
      val style = Style.PASCAL from Style.CAMEL
      assertEquals("SampleModel", "sampleModel".toStyle(style))
   }

   @Test
   fun upperFromSnake(){
      val style = Style.UPPERCASE from Style.SNAKE
      assertEquals("SAMPLE MODEL", "sample_model".toStyle(style))
   }
}