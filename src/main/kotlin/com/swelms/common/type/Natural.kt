package com.swelms.common.type

class Natural(value: Int): Restricted<Int>(value, { it > 1})