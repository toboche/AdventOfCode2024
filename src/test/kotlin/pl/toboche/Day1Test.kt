package pl.toboche

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day1Test {
    @Test
    internal fun task1Example() {
        val input = ("3   4\n" +
                "4   3\n" +
                "2   5\n" +
                "1   3\n" +
                "3   9\n" +
                "3   3")
            .lines()
        assertEquals(
            11,
            Day1().task1(input)
        )
    }

//    @Test
//    internal fun task1() {
//        val input = File("src/test/resources/day1Task1.txt")
//            .readText()
//            .lines()
//
//        assertEquals(
//            69206,
//            Day1().task1(input)
//        )
//    }
//

}