package com.swelms.common.collections

class Heap<T>(
    elements: Collection<T> = emptyList(),
    private val compare: (T, T) -> Int
) {

    private val data = elements.toMutableList()

    init { heapify() }

    fun push(x: T) {
        data.add(x)
        siftUp(data.lastIndex)
    }

    fun pop(): T? {
        if (data.isEmpty()) return null
        data.swap(0, data.lastIndex)
        val res = data.removeAt(data.lastIndex)
        siftDown(0)
        return res
    }

    val peek get() = data.firstOrNull()
    val size get() = data.size
    fun isEmpty() = data.isEmpty()

    private fun heapify() {
        for (i in parent(data.lastIndex) downTo 0) {
            siftDown(i)
        }
    }

    private fun siftUp(i0: Int) {
        var i = i0
        while (i > 0) {
            val p = parent(i)
            if (compare(data[i], data[p]) >= 0) break
            data.swap(i, p)
            i = p
        }
    }

    private fun siftDown(i0: Int) {
        var i = i0
        while (true) {
            val l = left(i)
            val r = right(i)
            var m = i

            if (l < data.size && compare(data[l], data[m]) < 0) m = l
            if (r < data.size && compare(data[r], data[m]) < 0) m = r
            if (m == i) break

            data.swap(i, m)
            i = m
        }
    }

    private fun parent(i: Int) = (i - 1) / 2
    private fun left(i: Int) = 2 * i + 1
    private fun right(i: Int) = 2 * i + 2
}

fun <T : Comparable<T>> naturalHeap(
    elements: Collection<T> = emptyList()
): Heap<T> = Heap(elements){ a, b -> a.compareTo(b) }