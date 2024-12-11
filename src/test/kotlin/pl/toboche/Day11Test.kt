package pl.toboche

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class Day11Test {
    @Test
    internal fun task1Example() {
        val input = ("125 17")
        assertEquals(
            55312,
            Day11().task1(input)
        )
    }

    @Test
    internal fun task1() {
        val input = File("src/test/resources/day11Task1.txt")
            .readText()

        assertEquals(
            2756096,
            Day11().task1(input)
        )
    }}