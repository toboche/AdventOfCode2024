package pl.toboche

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class Day5Test {
    @Test
    internal fun task1Example() {
        val input = ("47|53\n" +
                "97|13\n" +
                "97|61\n" +
                "97|47\n" +
                "75|29\n" +
                "61|13\n" +
                "75|53\n" +
                "29|13\n" +
                "97|29\n" +
                "53|29\n" +
                "61|53\n" +
                "97|53\n" +
                "61|29\n" +
                "47|13\n" +
                "75|47\n" +
                "97|75\n" +
                "47|61\n" +
                "75|61\n" +
                "47|29\n" +
                "75|13\n" +
                "53|13\n" +
                "\n" +
                "75,47,61,53,29\n" +
                "97,61,53,29,13\n" +
                "75,29,13\n" +
                "75,97,47,61,53\n" +
                "61,13,29\n" +
                "97,13,75,29,47")
            .lines()
        assertEquals(
            143,
            Day5().task1(input)
        )
    }

    @Test
    internal fun task1() {
        val input = File("src/test/resources/day5Task1.txt")
            .readText()
            .lines()

        assertEquals(
            4609,
            Day5().task1(input)
        )
    }

    @Test
    internal fun task2Example() {
        val input = ("47|53\n" +
                "97|13\n" +
                "97|61\n" +
                "97|47\n" +
                "75|29\n" +
                "61|13\n" +
                "75|53\n" +
                "29|13\n" +
                "97|29\n" +
                "53|29\n" +
                "61|53\n" +
                "97|53\n" +
                "61|29\n" +
                "47|13\n" +
                "75|47\n" +
                "97|75\n" +
                "47|61\n" +
                "75|61\n" +
                "47|29\n" +
                "75|13\n" +
                "53|13\n" +
                "\n" +
                "75,47,61,53,29\n" +
                "97,61,53,29,13\n" +
                "75,29,13\n" +
                "75,97,47,61,53\n" +
                "61,13,29\n" +
                "97,13,75,29,47")
            .lines()
        assertEquals(
            123,
            Day5().task2(input)
        )
    }

    @Test
    internal fun task2() {
        val input = File("src/test/resources/day5Task1.txt")
            .readText()
            .lines()

        assertEquals(
            4609,
            Day5().task2(input)
        )
    }
}