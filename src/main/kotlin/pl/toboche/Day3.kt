package pl.toboche

class Day3 {
    fun task1(input: String): Int {
        return Regex("mul\\((\\d{1,3}),(\\d{1,3})\\)")
            .findAll(input).map { result ->
                result.groups[1]!!.value.toInt() * result.groups[2]!!.value.toInt()
            }.sum()
    }
}