package pl.toboche

class Day4 {
    fun task1(input: List<String>): Int {
        val matrix = input.map { it.toCharArray() }
        var count = 0
        val remaining = listOf('M', 'A', 'S')
        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                if (matrix[i][j] == 'X') {
                    val toTheRight = (1..3).mapNotNull { k ->
                        matrix.getOrNull(i)?.getOrNull(j + k)
                    } == remaining
                    val toTheLeft = (1..3).mapNotNull { k ->
                        matrix.getOrNull(i)?.getOrNull(j - k)
                    } == remaining
                    val up = (1..3).mapNotNull { k ->
                        matrix.getOrNull(i - k)?.getOrNull(j)
                    } == remaining
                    val down = (1..3).mapNotNull { k ->
                        matrix.getOrNull(i + k)?.getOrNull(j)
                    } == remaining
                    val d1 = (1..3).mapNotNull { k ->
                        matrix.getOrNull(i - k)?.getOrNull(j - k)
                    } == remaining
                    val d2 = (1..3).mapNotNull { k ->
                        matrix.getOrNull(i - k)?.getOrNull(j + k)
                    } == remaining
                    val d3 = (1..3).mapNotNull { k ->
                        matrix.getOrNull(i + k)?.getOrNull(j - k)
                    } == remaining
                    val d4 = (1..3).mapNotNull { k ->
                        matrix.getOrNull(i + k)?.getOrNull(j + k)
                    } == remaining
                    count += if (toTheRight) 1 else 0
                    count += if (toTheLeft) 1 else 0
                    count += if (up) 1 else 0
                    count += if (down) 1 else 0
                    count += if (d1) 1 else 0
                    count += if (d2) 1 else 0
                    count += if (d3) 1 else 0
                    count += if (d4) 1 else 0
                }
            }
        }
        return count
    }

    fun task2(input: List<String>): Int {
        val matrix = input.map { it.toCharArray() }
        var count = 0
        val remaining1 = listOf('M', 'S')
        val remaining2 = listOf('S', 'M')
        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                if (matrix[i][j] == 'A') {
                    val d1 =
                        listOf(matrix.getOrNull(i - 1)?.getOrNull(j - 1), matrix.getOrNull(i + 1)?.getOrNull(j + 1))
                    val d2 =
                        listOf(matrix.getOrNull(i - 1)?.getOrNull(j + 1), matrix.getOrNull(i + 1)?.getOrNull(j - 1))

                    val d11 = d1 == remaining1 || d1 == remaining2
                    val d21 = d2 == remaining1 || d2 == remaining2
                    count += if (d11 && d21) 1 else 0
                }
            }
        }
        return count
    }

}