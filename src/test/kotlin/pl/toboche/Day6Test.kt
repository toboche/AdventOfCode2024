package pl.toboche

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

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
}