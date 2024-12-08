package pl.toboche

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day8Test {
    @Test
    internal fun task1Example() {
        val input = ("............\n" +
                "........0...\n" +
                ".....0......\n" +
                ".......0....\n" +
                "....0.......\n" +
                "......A.....\n" +
                "............\n" +
                "............\n" +
                "........A...\n" +
                ".........A..\n" +
                "............\n" +
                "............")
            .lines()
        assertEquals(
            14,
            Day8().task1(input)
        )
    }

    @Test
    internal fun task1Example2() {
        val input = ("..........\n" +
                "..........\n" +
                "..........\n" +
                "....a.....\n" +
                "..........\n" +
                ".....a....\n" +
                "..........\n" +
                "..........\n" +
                "..........\n" +
                "..........")
            .lines()
        assertEquals(
            2,
            Day8().task1(input)
        )
    }
}