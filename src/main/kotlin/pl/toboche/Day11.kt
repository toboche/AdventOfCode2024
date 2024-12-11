package pl.toboche

class Day11 {

    fun task1(input: String, count: Int = 25): Long {
        return input.split(" ")
            .map { it.toLong() }
            .map { number ->
                (0 until count).fold(mapOf(number to 1L)) { oldMap, iteration ->
                    val newMap = mutableMapOf<Long, Long>() //value, count
                    oldMap.forEach { (num, cnt) ->
                        if (num == 0L) {
                            newMap[1L] = cnt + newMap.getOrDefault(1L, 0L)
                        } else {
                            val str = num.toString()
                            if (str.count() % 2 == 0) {
                                val v1 = str.take(str.count() / 2).toLong()
                                val v2 = str.takeLast(str.count() / 2).toLong()
                                newMap[v1] = cnt + newMap.getOrDefault(v1, 0L)
                                newMap[v2] = cnt + newMap.getOrDefault(v2, 0L)
                            } else {
                                newMap[2024 * num] = cnt + newMap.getOrDefault(2024 * num, 0L)
                            }
                        }
                    }
                    newMap
                }.entries.sumOf { it.value }
            }.sum()
    }
}