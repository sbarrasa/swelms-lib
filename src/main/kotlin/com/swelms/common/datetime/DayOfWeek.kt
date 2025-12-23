package com.swelms.common.datetime

import kotlinx.datetime.DayOfWeek

object WeekDays {
   val WORK = DayOfWeek.MONDAY..DayOfWeek.FRIDAY
   val WEEKEND = DayOfWeek.SATURDAY..DayOfWeek.SUNDAY
}


val DayOfWeek.isWorkday get() = this in WeekDays.WORK
val DayOfWeek.isWeekend get() = this in WeekDays.WEEKEND

operator fun DayOfWeek.plus(n: Int): DayOfWeek =
   DayOfWeek.entries[(this.ordinal + n + DayOfWeek.entries.size) % DayOfWeek.entries.size]

operator fun DayOfWeek.minus(n: Int) = this + (-n)

operator fun DayOfWeek.inc() = this + 1
operator fun DayOfWeek.dec() = this - 1
