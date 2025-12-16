package com.swelms.domain.datetime

import com.swelms.common.datetime.*
import com.swelms.common.range.count
import kotlinx.datetime.DayOfWeek
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue


class DayOfWeekTest {



   @Test
   fun isWorkday() {
      assertTrue { DayOfWeek.WEDNESDAY.isWorkday }
      assertFalse { DayOfWeek.SUNDAY.isWorkday}

   }

   @Test
   fun isWeekEnd() {
      assertFalse { DayOfWeek.MONDAY.isWeekend }
      assertTrue { DayOfWeek.SUNDAY.isWeekend }
   }

   @Test
   fun nextDay(){
      var today = DayOfWeek.MONDAY
      assertEquals(DayOfWeek.TUESDAY, ++today)

   }

   @Test
   fun count(){
      assertEquals(5, WeekDays.WORK.count())
      assertEquals(2, WeekDays.WEEKEND.count())

   }
}