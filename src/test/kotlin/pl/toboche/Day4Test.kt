package pl.toboche

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class Day4Test {
    @Test
    internal fun task1Example() {
        val input = ("MMMSXXMASM\n" +
                "MSAMXMSMSA\n" +
                "AMXSXMAAMM\n" +
                "MSAMASMSMX\n" +
                "XMASAMXAMM\n" +
                "XXAMMXXAMA\n" +
                "SMSMSASXSS\n" +
                "SAXAMASAAA\n" +
                "MAMMMXMMMM\n" +
                "MXMXAXMASX")
            .lines()
        assertEquals(
            18,
            Day4().task1(input)
        )
    }

    @Test
    internal fun task1() {
        val input = File("src/test/resources/day4Task1.txt")
            .readText()
            .lines()

        assertEquals(
            2644,
            Day4().task1(input)
        )
    }
}