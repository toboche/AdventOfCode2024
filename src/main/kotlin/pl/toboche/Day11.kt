package pl.toboche

class Day11 {
    fun task1(input: String): Int {

        return input.split(" ")
            .map { it.toLong() }
            .map { number ->
                (0 until 25).fold(listOf(number)) { acc, i ->
                    acc.flatMap { cur ->
                        if (cur == 0L) {
                            listOf(1L)
                        } else {
                            val str = cur.toString()
                            if (str.count() % 2 == 0) {
                                listOf(str.take(str.count() / 2).toLong(), str.takeLast(str.count() / 2).toLong())
                            } else {
                                listOf(2024 * cur)
                            }
                        }
                    }
                }.count()
            }
            .sum()
    }
}