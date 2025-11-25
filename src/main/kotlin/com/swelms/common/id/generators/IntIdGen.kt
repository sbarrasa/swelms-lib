package com.swelms.common.id.generators

class IntIdGen(start: Int = 1) : IdGen<Int>(start) {
   override fun next(): Int {
      return current++
   }
}