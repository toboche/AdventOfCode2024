package pl.toboche

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class Day9Test {
    @Test
    internal fun task1Example0() {
        val input = ("12345")
        assertEquals(
            60,
            Day9().task1(input)
        )
    }

    @Test
    internal fun task1Example() {
        val input = ("2333133121414131402")
        assertEquals(
            1928,
            Day9().task1(input)
        )
    }

    @Test
    internal fun task1() {
        val input = File("src/test/resources/day9Task1.txt")
            .readText()

        assertEquals(
            2756096,
            Day9().task1(input)
        )
    }
}