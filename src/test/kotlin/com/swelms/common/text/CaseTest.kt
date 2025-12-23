package com.swelms.common.text

import kotlin.test.Test
import kotlin.test.assertEquals

class CaseConversionTest {

   @Test
   fun upper() {
      assertEquals("SAMPLE MODEL", "sample model".asStyle(Style.UPPERCASE))
   }

   @Test
   fun lower(){
      assertEquals("sample model", "sample model".asStyle(Style.LOWERCASE))
   }

   @Test
   fun snake(){
      assertEquals("sample_model", "sample model".asStyle(Style.SNAKE))
   }

   @Test
   fun snakeUpper(){
      assertEquals("SAMPLE_MODEL", "sample model".asStyle(Style.SNAKE + Style.UPPERCASE))
   }

   @Test
   fun pascal(){
      assertEquals("SampleModel", "sample model".asStyle(Style.PASCAL))
   }

   @Test
   fun kebab(){
      assertEquals("sample-model", "sample model".asStyle(Style.KEBAB))
   }

   @Test
   fun camel(){
      assertEquals("sampleModel", "sample model".asStyle(Style.CAMEL))
   }


   @Test
   fun dot(){
      assertEquals("sample.model", "sample model".asStyle(Style.DOT))
   }

   @Test
   fun custom(){
      val style = Style(words = Case.LOWER, joinChar = null)
      assertEquals("samplemodel", "SAMPLE MODEL".asStyle(style))
   }

   @Test
   fun customFirst(){
      val style = Style(words = Case.LOWER, capitalFirst = Case.UPPER)
      assertEquals("Sample model", "SAMPLE MODEL".asStyle(style))
   }

   @Test
   fun customDotInput(){
      val style = Style(splitChar = '.', capital = Case.UPPER, joinChar = null)
      assertEquals("SampleModel", "sample.model".asStyle(style))
   }

   @Test
   fun title(){
      assertEquals("Sample Model", "sample model".asStyle(Style.TITLE))
   }

   @Test
   fun dotToPath(){
      val style = Style.unixPath from Style.DOT
      assertEquals("com/swelms/text", "com.swelms.text".asStyle(style))
   }

   @Test
   fun unixToWindowsPath(){
      val style = Style.windowsPath from Style.unixPath
      assertEquals("com\\swelms\\text", "com/swelms/text".asStyle(style))
   }

   @Test
   fun snakeToCamel(){
      val style = Style.CAMEL from Style.SNAKE
      assertEquals("sampleModel", "sample_model".asStyle(style))
   }


   @Test
   fun upperFromSnake(){
      val style = Style.UPPERCASE.copy(splitChar = '_')
      assertEquals("SAMPLE MODEL", "sample_model".asStyle(style))
   }

   @Test
   fun snakePlusTitle(){
      assertEquals("Sample_Model", "sample model".asStyle(Style.SNAKE + Style.TITLE))
   }

   @Test
   fun camelKebab(){
      val style = Style.KEBAB + Style.LOWERCASE + Style.CAMEL
      assertEquals("sample-Model", "SAMPLE MODEL".asStyle(style))
   }

   @Test
   fun invertTitle(){
      val style = !Style.TITLE
      assertEquals("sAMPLE mODEL", "sample model".asStyle(style))
   }

}