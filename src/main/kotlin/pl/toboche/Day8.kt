package pl.toboche

class Day8 {
    fun task1(input: List<String>, print: Boolean = false): Int {
        val antennaTypeToAntennaLocations: MutableMap<Char, List<Pair<Int, Int>>> = mutableMapOf()

        input.forEachIndexed { j, row ->
            row.forEachIndexed { i, char ->
                if (char != '.') {
                    antennaTypeToAntennaLocations[char] =
                        antennaTypeToAntennaLocations.getOrDefault(char, emptyList()) + (i to j)
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
                    val diff = second.first - first.first to second.second - first.second
                    allAntinodes.add(first.first - diff.first to first.second - diff.second)
                    allAntinodes.add(second.first + diff.first to second.second + diff.second)
                }
            }
        }
        val filtered = allAntinodes
            .filter { it.first in input.first().indices && it.second in input.indices }

        if (print) {
            input.forEachIndexed { j, row ->
                row.forEachIndexed { i, char ->
                    if (filtered.contains(i to j)) {
                        print('#')
                    } else
                        if (char != '.') {
                            print(char)
                        } else {
                            print('.')
                        }
                }
                print('\n')
            }
        }

        return filtered
            .count()
    }
}