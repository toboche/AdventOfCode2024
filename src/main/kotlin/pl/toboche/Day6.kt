package pl.toboche

class Day6 {
    fun task1(input: List<String>): Int {
        var currentPosition: Pair<Int, Int>? = null
        var currentDirection: Pair<Int, Int>? = null
        val map = input
            .reversed()
            .mapIndexed { y, line ->
                line.mapIndexed { x, char ->
                    when (char) {
                        '#' -> true
                        'v' -> {
                            currentDirection = 0 to -1
                            currentPosition = x to y
                            false
                        }

                        '^' -> {
                            currentDirection = 0 to 1
                            currentPosition = x to y
                            false
                        }

                        '<' -> {
                            currentDirection = -1 to 0
                            currentPosition = x to y
                            false
                        }

                        '>' -> {
                            currentPosition = x to y
                            currentDirection = 1 to 0
                            false
                        }

                        else -> false
                    }
                }
            }
        val visited = mutableListOf<Pair<Int, Int>>()
        while (currentPosition!!.second in map.indices && currentPosition!!.first in map[0].indices) {
            visited.add(currentPosition!!)

            val nextLinearPosition = currentPosition!!.copy(
                first = currentPosition!!.first + currentDirection!!.first,
                second = currentPosition!!.second + currentDirection!!.second
            )
            val facingObstacle = map.getOrElse(nextLinearPosition!!.second, { emptyList<Boolean>() })
                .getOrElse(nextLinearPosition!!.first, { false })
            if (!facingObstacle) {
                currentPosition = nextLinearPosition
            } else {
                currentDirection = if (currentDirection!!.second == 0) {
                    -currentDirection!!.second to -currentDirection!!.first
                } else {
                    currentDirection!!.second to currentDirection!!.first
                }

                currentPosition =
                    currentPosition!!.first + currentDirection!!.first to
                            currentPosition!!.second + currentDirection!!.second

            }
        }
        return visited.distinct().count()
    }
}