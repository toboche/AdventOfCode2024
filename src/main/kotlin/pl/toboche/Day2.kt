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

    fun task2(input: List<String>): Int {
        return input.map {
            val ints = it.split(" ").map {
                it.toInt()
            }
            var curr = ints.first()
            val second = ints[1]
            val increasing = second - curr > 0
            var skippedOne = false
            for (i in ints.indices.drop(1)) {
                val next = ints[i]
                when (increasing) {
                    true -> {
                        if (next - curr !in 1..3) {
                            if (skippedOne) {
                                return@map false
                            } else {
                                skippedOne = true
                                continue
                            }
                        }
                    }

                    false -> {
                        if (next - curr !in -3..-1) {
                            if (skippedOne) {
                                return@map false
                            } else {
                                skippedOne = true
                                continue
                            }
                        }
                    }
                }
                curr = next
            }
            return@map true

        }
            .count { it }

    }
}