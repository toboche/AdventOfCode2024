package pl.toboche

class Day12 {
    fun task1(input: List<String>): Int {
        val map = input.map { it.toCharArray() }.toTypedArray()
        val checked = (0..input.size).map { input[0].map { false }.toTypedArray() }.toTypedArray()

        fun checkCoords(y: Int, x: Int, expectedChar: Char): Pair<Int, Int> {//area to perimeter
            if (checked.getOrNull(y)?.getOrNull(x) != false) {
                return 0 to 0
            }
            if (map.getOrNull(y)?.getOrNull(x) == expectedChar) {
                checked[y][x] = true
                val right = checkCoords(y, x + 1, expectedChar)
                val bottom = checkCoords(y + 1, x, expectedChar)
                val top = checkCoords(y - 1, x, expectedChar)
                val left = checkCoords(y, x - 1, expectedChar)
                val rightPerimeterToAdd = if (map.getOrNull(y)?.getOrNull(x + 1) != expectedChar) 1 else right.second
                val bottomPerimeterToAdd = if (map.getOrNull(y + 1)?.getOrNull(x) != expectedChar) 1 else bottom.second
                val topPerimeterToAdd = if (map.getOrNull(y - 1)?.getOrNull(x) != expectedChar) 1 else top.second
                val leftPerimeterToAdd = if (map.getOrNull(y)?.getOrNull(x - 1) != expectedChar) 1 else left.second

                return (1 + right.first + bottom.first + top.first + left.first) to rightPerimeterToAdd + bottomPerimeterToAdd + topPerimeterToAdd + leftPerimeterToAdd
            } else {
                return 0 to 0
            }
        }

        var sum = mutableListOf<Pair<Int, Int>>()
        for (y in map.indices) {
            val row = map[y]
            for (x in row.indices) {
                if (checked.getOrNull(y)?.getOrNull(x) != false) {
                    continue
                }
                sum.add(checkCoords(y, x, map[y][x]))
//                val currentChar = map[y][x]
//                checked[y][x] = true
//                checkCoords(y, x + 1, currentChar)
//                checkCoords(y + 1, x, currentChar)

            }
        }
        return sum.sumOf { it.first * it.second }

    }
}