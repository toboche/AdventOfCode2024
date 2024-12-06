package pl.toboche

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class Day6Test {
    @Test
    internal fun task1Example() {
        val input = ("....#.....\n" +
                ".........#\n" +
                "..........\n" +
                "..#.......\n" +
                ".......#..\n" +
                "..........\n" +
                ".#..^.....\n" +
                "........#.\n" +
                "#.........\n" +
                "......#...")
            .lines()
        assertEquals(
            41,
            Day6().task1(input)
        )
    }

    @Test
    internal fun task1() {
        val input = File("src/test/resources/day6Task1.txt")
            .readText()
            .lines()

        assertEquals(
            4826,
            Day6().task1(input)
        )
    }
}