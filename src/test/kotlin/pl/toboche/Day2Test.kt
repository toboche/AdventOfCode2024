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
    @Test
    internal fun task2Example2() {
        val input = ("61 64 67 66 68 67")
            .lines()
        assertEquals(
            0,
            Day2().task2(input)
        )
    }

    @Test
    internal fun task2Example3() {
        val input = ("1 2 3 4 5 0 6")
            .lines()
        assertEquals(
            1,
            Day2().task2(input)
        )
    }

    @Test
    internal fun task2Example4() {
        val input = ("1 2 3 4 5 0")
            .lines()
        assertEquals(
            1,
            Day2().task2(input)
        )
    }
    @Test
    internal fun task2Example5() {
        val input = ("75 77 72 70 69\n" +
                "28 28 27 26 23\n" +
                "74 70 71 70 68 65\n" +
                "20 16 14 12 10 8 7 6")
            .lines()
        assertEquals(
            4,
            Day2().task2(input)
        )
    }

    @Test
    internal fun task2Example6() {
        val input = (
                "74 70 71 70 68 65")
            .lines()
        assertEquals(
            1,
            Day2().task2(input)
        )
    }
    @Test
    internal fun task2() {
        val input = File("src/test/resources/day2Task1.txt")
            .readText()
            .lines()

        assertEquals(
//            285, to high
//            295, to high
//            304 incorrect
            296,// incorrect
            Day2().task2(input)
        )
    }
}