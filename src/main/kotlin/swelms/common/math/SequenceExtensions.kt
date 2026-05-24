package swelms.common.math

fun <T> Sequence<T>.nth(n: Int): T = elementAt(n - 1)