package pl.toboche

class Day5 {
    fun task1(input: List<String>): Int {
        val rulesEnd = input.indexOfFirst { it.isBlank() }
        val rules = input.take(rulesEnd)
            .map {
                val (a, b) = it.split('|')
                a.toInt() to b.toInt()
            }.groupBy(keySelector = { it.first }, valueTransform = { it.second })
        val updates = input.drop(rulesEnd + 1)
            .map { it.split(',').map { it.toInt() } }
        return updates.filter { update ->
            update.foldIndexed(true) { currentIndexInUpdate, acc, pageToUpdate ->
                val pagesRequiredAfter = rules.getOrDefault(pageToUpdate, emptyList())
                acc && pagesRequiredAfter.fold(true) { accForSinglePageAfter, pageRequiredAfter ->
                    accForSinglePageAfter && (update.indexOf(
                        pageRequiredAfter
                    ).let {
                        if (it == -1) {
                            Int.MAX_VALUE
                        } else {
                            it
                        }
                    } > currentIndexInUpdate)
                }
            }
        }.sumOf { it[it.size / 2] }
    }

    fun task2(input: List<String>): Int {
        val left = mutableListOf<Int>()
        val right = mutableListOf<Int>()
        input.forEach() {
            val (l, r) = it.split("   ").map { it.toInt() }
            left.add(l)
            right.add(r)
        }
        left.sort()
        val rightCounts = right.withCounts()
        return left.indices.sumOf {
            left[it] * ((rightCounts[left[it]]) ?: 0)

        }
    }

}