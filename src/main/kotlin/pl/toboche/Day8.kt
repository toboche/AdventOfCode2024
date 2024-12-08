package pl.toboche

class Day8 {
    fun task1(input: List<String>): Int {
        val antennaTypeToAntennaLocations: MutableMap<Char, List<Pair<Int, Int>>> = mutableMapOf()

        input.forEachIndexed { j, row ->
            row.forEachIndexed { i, char ->
                run {
                    if (char != '.') {
                        antennaTypeToAntennaLocations[char] =
                            antennaTypeToAntennaLocations.getOrDefault(char, emptyList()) + (i to j)
                    }
                }
            }
        }

        val allAntinodes = mutableSetOf<Pair<Int, Int>>()
        antennaTypeToAntennaLocations.map { (char, antennaLocations) ->
            for (first in antennaLocations) {
                for (second in antennaLocations) {
                    if (first == second || first.first > second.first) {
                        continue
                    }
                    val diff = first.first - second.first to first.second - second.second
                    allAntinodes.add(second.first - diff.first to second.second - diff.second)
                    allAntinodes.add(first.first + diff.second to first.second + diff.first)
                }
            }
        }
        val filtered = allAntinodes
            .filter { it.first in input.first().indices && it.second in input.indices }
        return filtered
            .count()
    }
}