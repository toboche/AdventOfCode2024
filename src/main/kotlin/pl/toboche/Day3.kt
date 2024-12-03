package pl.toboche

class Day3 {
    fun task1(input: String): Int {
        return Regex("mul\\((\\d{1,3}),(\\d{1,3})\\)")
            .findAll(input).map { result ->
                result.groups[1]!!.value.toInt() * result.groups[2]!!.value.toInt()
            }.sum()
    }

    fun task2(input: String): Int {
        var enabled = true
        val findAll = Regex("""(mul\((\d{1,3}),(\d{1,3})\))|(do\(\))|(don't\(\))""")
            .findAll(input)
            .sortedBy { it.range.first }
        return findAll.fold(0) { acc, result ->
            if (result.groups[1]?.value?.contains("mul") == true && enabled) {
                acc + result.groups[2]!!.value.toInt() * result.groups[3]!!.value.toInt()
            } else if (result.groups[5]?.value?.contains("don") == true) {
                enabled = false
                acc
            } else if (result.groups[4]?.value?.contains("do") == true) {
                enabled = true
                acc
            } else {
                acc
            }
        }
    }
}