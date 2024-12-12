package pl.toboche

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day12Test {
    @Test
    internal fun task1Example() {
        val input = ("AAAA\n" +
                "BBCD\n" +
                "BBCC\n" +
                "EEEC")
            .lines()
        assertEquals(
            140,
            Day12().task1(input)
        )
    }

    @Test
    internal fun task1Example2() {
        val input = ("RRRRIICCFF\n" +
                "RRRRIICCCF\n" +
                "VVRRRCCFFF\n" +
                "VVRCCCJFFF\n" +
                "VVVVCJJCFE\n" +
                "VVIVCCJJEE\n" +
                "VVIIICJJEE\n" +
                "MIIIIIJJEE\n" +
                "MIIISIJEEE\n" +
                "MMMISSJEEE")
            .lines()
        assertEquals(
            1930,
            Day12().task1(input)
        )
    }
}