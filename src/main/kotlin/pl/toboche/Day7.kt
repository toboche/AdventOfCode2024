package pl.toboche

class Day7 {
    fun task1(input: List<String>): Long {
        return input.sumOf {
            val (expectedResultString, valuesString) = it.split(": ")
            val expectedResult = expectedResultString.toLong()
            val values = valuesString.split(' ').map { it.toLong() }
            var possibleOutcomes = listOf(values.first())
            for (value in values.drop(1)) {
                possibleOutcomes = possibleOutcomes.flatMap { possibleResult ->
                    listOf(
                        possibleResult + value,
                        possibleResult * value
                    )
                }
            }
            if (possibleOutcomes.contains(expectedResult)) {
                expectedResult
            } else {
                0
            }
        }
    }

}