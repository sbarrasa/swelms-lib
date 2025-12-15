package com.swelms.domain.rate

import kotlin.test.*

class RatingTest {
   @Test
   fun average1() {
      val rating = Rating()
      rating.add(5)
      rating.add(2)
      rating.add(3)

      assertEquals(3, rating.averageRounded())
   }

   @Test
   fun average2() {
      val rating = Rating(10,2)
      rating.add(5)

      assertEquals(15, rating.sum())
      assertEquals(3, rating.count())

      assertEquals(5.0, rating.average())
   }

   @Test
   fun invalidRange() {
      val rating = Rating(range = 1..5)
      assertFailsWith<IllegalArgumentException> {  rating.add(10)}
   }



}