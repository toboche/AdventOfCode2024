package pl.toboche

class Day7 {
    fun task1(input: List<String>): Long {
        return solve(input, listOf(
            { a, b -> a + b },
            { a, b -> a * b }
        ))
    }

    fun task2(input: List<String>): Long {
        return solve(input, listOf(
            { a, b -> a + b },
            { a, b -> a * b },
            { a, b -> (a.toString() + b.toString()).toLong() }
        ))
    }

    private fun solve(input: List<String>, ops: List<(Long, Long) -> Long>) = input.sumOf {
        val (expectedResultString, valuesString) = it.split(": ")
        val expectedResult = expectedResultString.toLong()
        val values = valuesString.split(' ').map { it.toLong() }
        var possibleOutcomes = listOf(values.first())
        for (value in values.drop(1)) {
            possibleOutcomes = possibleOutcomes.flatMap { possibleResult ->
                ops.map { op ->
                    op(possibleResult, value)
                }
            }
        }
        if (possibleOutcomes.contains(expectedResult)) {
            expectedResult
        } else {
            0
        }
    }

}