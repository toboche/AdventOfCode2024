package pl.toboche

class Day9 {
    fun task1(input: String): Long {
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
            newOccupiedIndices.find { it.first == i }?.second
                ?: occupiedIndices.find { it.first == i }?.second!!
        }
            .withIndex().sumOf { it.index.toLong() * it.value.toLong() }
    }

    fun task2(input: String): Long {
        val freeSpaceRanges = mutableListOf<Pair<Int, Int>>()
        val occupiedRanges = mutableListOf<Pair<Int, Pair<Int, Int>>>()// id to range
        var currentMemoryIndex = 0
        var currentId = 0
        input.withIndex().forEach { inputEntry ->
            if ((inputEntry.index % 2) == 0) {
                val newEntries = (0 until inputEntry.value.digitToInt()).map { currentMemoryIndex + it to currentId }
                occupiedRanges.add(currentId to (currentMemoryIndex to currentMemoryIndex + inputEntry.value.digitToInt() - 1))
                currentMemoryIndex += inputEntry.value.digitToInt()
                currentId += 1
            } else if (inputEntry.value.digitToInt() == 0) else {
                freeSpaceRanges.add(currentMemoryIndex to currentMemoryIndex + inputEntry.value.digitToInt() - 1)
                currentMemoryIndex += inputEntry.value.digitToInt()
            }
        }
        val a = occupiedRanges.reversed()
            .map { occupiedRange ->
                val spaceToPutCurrent = freeSpaceRanges.withIndex()
                    .firstOrNull() { (_, it) -> it.second - it.first >= occupiedRange.second.second - occupiedRange.second.first }
                if (spaceToPutCurrent == null) {
                    return@map occupiedRange
                }
                val (spaceToPutCurrentIndex, spaceToPutCurrentRange) = spaceToPutCurrent
                if (spaceToPutCurrentRange.first > occupiedRange.second.first) {
                    return@map occupiedRange
                }
                freeSpaceRanges.remove(spaceToPutCurrentRange)
                val lengthToTake = occupiedRange.second.second - occupiedRange.second.first + 1
                val lengthOfTheSpaceThatWillBeTaken = spaceToPutCurrentRange.second - spaceToPutCurrentRange.first + 1
                if (lengthOfTheSpaceThatWillBeTaken > lengthToTake) {
                    val spaceLeftToOccupy =
                        spaceToPutCurrentRange.second - (lengthOfTheSpaceThatWillBeTaken - lengthToTake - 1) to spaceToPutCurrentRange.second
                    freeSpaceRanges.add(spaceToPutCurrentIndex, spaceLeftToOccupy)
                }
                return@map occupiedRange.first to (spaceToPutCurrentRange.first to spaceToPutCurrentRange.second - lengthOfTheSpaceThatWillBeTaken + lengthToTake)
            }
        val sum = a.map { (id, range) ->
            (range.first..range.second).sumOf {
                it.toLong() * id.toLong()
            }
        }.sum()
        return sum
    }

}