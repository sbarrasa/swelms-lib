package com.swelms.common

inline fun <T, S> T.applyFrom(source: S, block: T.(S) -> Unit): T {
   this.block(source)
   return this
}
