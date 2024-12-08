package pl.toboche

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class Day7Test {
    @Test
    internal fun task1Example() {
        val input = ("190: 10 19\n" +
                "3267: 81 40 27\n" +
                "83: 17 5\n" +
                "156: 15 6\n" +
                "7290: 6 8 6 15\n" +
                "161011: 16 10 13\n" +
                "192: 17 8 14\n" +
                "21037: 9 7 18 13\n" +
                "292: 11 6 16 20")
            .lines()
        assertEquals(
            3749,
            Day7().task1(input)
        )
    }

    @Test
    internal fun task1() {
        val input = File("src/test/resources/day7Task1.txt")
            .readText()
            .lines()

        assertEquals(
            1289579105366,
            Day7().task1(input)
        )
    }

    @Test
    internal fun task2Example() {
        val input = ("190: 10 19\n" +
                "3267: 81 40 27\n" +
                "83: 17 5\n" +
                "156: 15 6\n" +
                "7290: 6 8 6 15\n" +
                "161011: 16 10 13\n" +
                "192: 17 8 14\n" +
                "21037: 9 7 18 13\n" +
                "292: 11 6 16 20")
            .lines()
        assertEquals(
            11387,
            Day7().task2(input)
        )
    }
}