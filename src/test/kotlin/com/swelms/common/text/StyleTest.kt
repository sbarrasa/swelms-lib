package com.swelms.common.text

import kotlin.test.Test
import kotlin.test.assertEquals

class StyleTest {

   @Test
   fun upper() {
      assertEquals("SAMPLE MODEL", "sample model".applyStyle(Style.UPPERCASE))
   }

   @Test
   fun lower(){
      assertEquals("sample model", "sAmPle MODEL".applyStyle(Style.LOWERCASE))
   }

   @Test
   fun snake(){
      assertEquals("sample_model", "sample model".applyStyle(Style.SNAKE))
   }

   @Test
   fun snakeUpper(){
      val style = Style.SNAKE + Style.UPPERCASE
      assertEquals("SAMPLE_MODEL", "sample model".applyStyle(style))
   }

   @Test
   fun pascal(){
      assertEquals("SampleModel", "sample model".applyStyle(Style.PASCAL))
   }

   @Test
   fun kebab(){
      assertEquals("sample-model", "sample model".applyStyle(Style.KEBAB))
   }

   @Test
   fun camel(){
      assertEquals("sampleModel", "sample model".applyStyle(Style.CAMEL))
   }


   @Test
   fun dot(){
      assertEquals("sample.model.dot", "sample model dot".applyStyle(Style.DOT))
   }

   @Test
   fun custom(){
      val style = Style(wordsCase = Case.LOWER, joinChar = null)
      assertEquals("samplemodel", "SAMPLE MODEL".applyStyle(style))
   }

   @Test
   fun customFirst(){
      val style = Style(wordsCase = Case.LOWER, firstCharCase = Case.UPPER)
      assertEquals("Sample model", "SAMPLE MODEL".applyStyle(style))
   }

   @Test
   fun customDotInput(){
      val style = Style(splitChar = '.', firstWordCharCase = Case.UPPER, joinChar = null)
      assertEquals("SampleModel", "sample.model".applyStyle(style))
   }

   @Test
   fun customTitleNoSpace(){
      val style = Style.TITLE.copy(joinChar = null)
      assertEquals("SampleModel", "sample model".applyStyle(style))
      assertEquals(Style.PASCAL, style)
   }

   @Test
   fun title(){
      assertEquals("Sample Model", "sample model".applyStyle(Style.TITLE))
   }

   @Test
   fun dotToPath(){
      val style = Style.DOT to Style.unixPath
      assertEquals("com/swelms/text", "com.swelms.text".applyStyle(style))
   }

   @Test
   fun unixToWindowsPath(){
      val style = Style.unixPath to Style.windowsPath
            assertEquals("com\\swelms\\text", "com/swelms/text".applyStyle(style))
   }

   @Test
   fun camelToSnake(){
      val style = Style.SNAKE to Style.CAMEL
      assertEquals("sampleModel", "sample_model".applyStyle(style))
   }


   @Test
   fun snakeToUpper(){
      val style = Style.SNAKE to Style.UPPERCASE

      assertEquals("SAMPLE MODEL", "sample_model".applyStyle(style))
   }

   @Test
   fun snakePlusTitle(){
      val style = Style.SNAKE + Style.TITLE
      assertEquals("Sample_Model", "sample model".applyStyle(style))
   }

   @Test
   fun camelKebab(){
      val style = Style.KEBAB + Style.LOWERCASE + Style.CAMEL
      assertEquals("sample-Model", "SAMPLE MODEL".applyStyle(style))
   }

   @Test
   fun invertTitle(){
      assertEquals("sAMPLE mODEL", "sample model".applyStyle(!Style.TITLE))
   }


}
