package pl.toboche

class Day2 {
    fun task1(input: List<String>): Int {
        return input.map {
            val ints = it.split(" ").map {
                it.toInt()
            }
            var curr = ints.first()
            val second = ints[1]
            var increasing = second - curr > 0
            for (i in ints.indices.drop(1)) {
                val next = ints[i]
                when (increasing) {
                    true -> {
                        if (next - curr !in 1..3) {
                            return@map false
                        }
                    }

                    false -> {
                        if (next - curr !in -3..-1) {
                            return@map false
                        }
                    }
                }
                curr = next
            }
            return@map true

        }
            .count { it }

    }

    data class FoldOperation(
        val increasingOrDecreasing: Boolean?,
        val valid: Boolean,
    )
}