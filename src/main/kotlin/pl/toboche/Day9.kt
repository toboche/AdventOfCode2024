package pl.toboche

class Day9 {
    fun task1(input: String): Int {
        val freeSpaceIndices = mutableListOf<Int>()
        val occupiedIndices = mutableListOf<Pair<Int, Int>>()// index, id
        var currentMemoryIndex = 0
        var currentId = 0
        input.withIndex().forEach { inputEntry ->
            if ((inputEntry.index % 2) == 0) {
                val newEntries = (0 until inputEntry.value.digitToInt()).map { currentMemoryIndex + it to currentId }
                occupiedIndices.addAll(
                    newEntries
                )
                currentMemoryIndex += inputEntry.value.digitToInt()
                currentId += 1
            } else {
                freeSpaceIndices.addAll(
                    (0 until inputEntry.value.digitToInt()).map { currentMemoryIndex + it }
                )
                currentMemoryIndex += inputEntry.value.digitToInt()
            }
        }
        val newOccupiedIndices = freeSpaceIndices
            .dropLast(if (input.count() % 2 == 1) 1 else 4)
            .zip(occupiedIndices.reversed())
            .map { (newIndex, oldIndexToId) ->
                val (oldIndex, id) = oldIndexToId
                newIndex to id
            }
        return (0 until occupiedIndices.size).map { i ->
            newOccupiedIndices.find { it.first == i }?.second?.digitToChar()
                ?: occupiedIndices.find { it.first == i }?.second?.digitToChar() ?: '.'
        }
            .withIndex().sumOf { it.index * it.value.digitToInt() }
    }
}