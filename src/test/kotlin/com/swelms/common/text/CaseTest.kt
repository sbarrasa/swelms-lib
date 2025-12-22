package com.swelms.common.text

import kotlin.test.Test
import kotlin.test.assertEquals

class CaseConversionTest {


   @Test
   fun upper() {
      assertEquals("SAMPLE MODEL", Case.UPPER.sample)
   }

   @Test
   fun lower(){
      assertEquals("sample model", Case.LOWER.sample)
   }

   @Test
   fun snake(){
      assertEquals("sample_model", Case.SNAKE.sample)
   }

   @Test
   fun snakeUpper(){
      assertEquals("HOLA_MUNDO", "hola mundo".toCase(Case.SNAKE).toCase(Case.UPPER))
   }

   @Test
   fun pascal(){
      assertEquals("SampleModel", Case.PASCAL.sample)
   }

   @Test
   fun camel(){
      assertEquals("sample-model", Case.KEBAB.sample)
   }

   @Test
   fun kebab(){
      assertEquals("sampleModel", Case.CAMEL.sample)
   }


   @Test
   fun dot(){
      assertEquals("sample.model", Case.DOT.sample)
   }

   @Test
   fun separated(){
      assertEquals("sample:model", Case.SEPARATED(':').sample)
   }

}