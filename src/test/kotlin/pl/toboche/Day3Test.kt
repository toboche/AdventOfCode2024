package pl.toboche

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class Day3Test {
    @Test
    internal fun task1Example() {
        val input = ("xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))")
        assertEquals(
            161,
            Day3().task1(input)
        )
    }

    @Test
    internal fun task1() {
        val input = File("src/test/resources/day3Task1.txt")
            .readText()

        assertEquals(
            169021493,
            Day3().task1(input)
        )
    }

    @Test
    internal fun task2Example() {
        val input = ("xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))\n")
        assertEquals(
            48,
            Day3().task2(input)
        )
    }

    @Test
    internal fun task2() {
        val input = File("src/test/resources/day3Task1.txt")
            .readText()

        assertEquals(
            169021493,
            Day3().task2(input)
        )
    }
}