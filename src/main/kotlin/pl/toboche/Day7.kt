package pl.toboche

class Day7 {
    fun task1(input: List<String>): Int {
        return input.map {
            val (expectedResultString, valuesString) = it.split(": ")
            val expectedResult = expectedResultString.toInt()
            val values = valuesString.split(' ').map { it.toInt() }
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
        }.sum()
    }

}