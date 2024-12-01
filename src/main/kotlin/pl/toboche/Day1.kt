package pl.toboche

import kotlin.math.abs
import kotlin.math.min

class Day1 {
    fun task1(input: List<String>): Int {
        val left = mutableListOf<Int>()
        val right = mutableListOf<Int>()
        input.forEach() {
            val (l, r) = it.split("   ").map { it.toInt() }
            left.add(l)
            right.add(r)
        }
        left.sort()
        right.sort()
        return left.indices.map {
            min(abs(left[it] - right[it]),abs(right[it] - left[it]))
        }
            .sum()
    }

//    fun task2(input: List<String>): Int {
//        val sums = mutableListOf<Int>()
//        var sum = 0
//        input.forEach {
//            if (it.isEmpty()) {
//                sums.add(sum)
//                sum = 0
//            } else {
//                sum += it.toInt()
//            }
//        }
//        sums.add(sum)
//        return sums.sortedDescending().take(3).sum()
//    }
}