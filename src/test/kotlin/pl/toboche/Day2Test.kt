package pl.toboche

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class Day2Test {
    @Test
    internal fun task1Example() {
        val input = ("7 6 4 2 1\n" +
                "1 2 7 8 9\n" +
                "9 7 6 2 1\n" +
                "1 3 2 4 5\n" +
                "8 6 4 4 1\n" +
                "1 3 6 7 9")
            .lines()
        assertEquals(
            2,
            Day2().task1(input)
        )
    }

    @Test
    internal fun task1() {
        val input = File("src/test/resources/day2Task1.txt")
            .readText()
            .lines()

        assertEquals(
            230,
            Day2().task1(input)
        )
    }

    @Test
    internal fun task2Example() {
        val input = ("7 6 4 2 1\n" +
                "1 2 7 8 9\n" +
                "9 7 6 2 1\n" +
                "1 3 2 4 5\n" +
                "8 6 4 4 1\n" +
                "1 3 6 7 9")
            .lines()
        assertEquals(
            4,
            Day2().task2(input)
        )
    }
}