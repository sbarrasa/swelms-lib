package com.swelms.common.collections

interface Mappeable<K,T> {
   fun asMap(): Map<K, T>
}

