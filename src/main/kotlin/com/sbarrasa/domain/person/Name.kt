package com.sbarrasa.domain.person

interface Name  {
   val text: String
   val list: List<String> get() = text.split(" ")
   operator fun get(index: Int) = list[index-1]
   val count: Int get() = list.size

}