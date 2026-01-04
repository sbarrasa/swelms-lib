package com.swelms.common.math

import kotlin.test.Test
import kotlin.test.assertEquals

class ComplexTest {

   @Test
   fun testAddition() {
      val a = Complex(1.0, 2.0)
      val b = Complex(3.0, 4.0)
      assertEquals(Complex(4.0, 6.0), a + b)
   }

   @Test
   fun testSubtraction() {
      val a = Complex(5.0, 6.0)
      val b = Complex(2.0, 3.0)
      assertEquals(Complex(3.0, 3.0), a - b)
   }

   @Test
   fun testMultiplication() {
      val a = Complex(1.0, 2.0)
      val b = Complex(3.0, 4.0)
      assertEquals(Complex(-5.0, 10.0), a * b)
   }

   @Test
   fun testDivision() {
      val a = Complex(1.0, 2.0)
      val b = Complex(3.0, 4.0)
      assertEquals(Complex(0.44, 0.08), a / b)
   }

   @Test
   fun testSqrtInt() {
      assertEquals(Complex(0.0, 1.0), Complex.sqrt(-1))
      assertEquals(2, Complex.sqrt(4).toInt())
   }

   @Test
   fun testSqrtDouble() {
      assertEquals(Complex(0.0, 2.0), Complex.sqrt(-4.0))
      assertEquals(Complex(3.0, 0.0), Complex.sqrt(9.0))
   }


   @Test
   fun testDoubleOperations() {
      val d = Complex(2.0)
      val c = Complex(1.0, 3.0)
      assertEquals(Complex(3.0, 3.0), d + c)
      assertEquals(Complex(1.0, -3.0), d - c)
      assertEquals(Complex(2.0, 6.0), d * c)
      assertEquals(Complex(0.2, -0.6), d / c)
   }

   @Test
   fun test_i(){
      assertEquals(Complex.i, Complex.sqrt(-1))
   }

}
