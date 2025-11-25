package com.swelms.common.id.generators

abstract class IdGen<T : Any>(start: T) {
   protected var current: T = start
   abstract fun next(): T
}