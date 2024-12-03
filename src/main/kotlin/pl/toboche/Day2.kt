package pl.toboche

class Day2 {
    fun task1(input: List<String>): Int {
        return input.map {
            val ints = it.split(" ").map {
                it.toInt()
            }
            check(ints)

        }
            .count { it }

    }

    fun task2(input: List<String>): Int {
        return input.map {
            val ints = it.split(" ").map {
                it.toInt()
            }

            ints.withIndex().map { i ->
                val sublist = ints.filterIndexed { index, int -> index != i.index }
                check(sublist)
            }.fold(false, { acc, bool -> acc || bool })


        }
            .count { it }

    }

    fun check(ints: List<Int>): Boolean {
        var curr = ints.first()
        val second = ints[1]
        val increasing = second - curr > 0
        for (i in ints.indices.drop(1)) {
            val next = ints[i]
            when (increasing) {
                true -> {
                    if (next - curr !in 1..3) {
                        return false
                    }
                }

                false -> {
                    if (next - curr !in -3..-1) {
                        return false
                    }
                }
            }
            curr = next
        }
        return true
    }

}