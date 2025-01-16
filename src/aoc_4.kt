import java.lang.Math.pow
import kotlin.math.pow

fun calculatePoints(input: String): Double {
    val inputLines = input.lines()
        .map { it.split(": ")[1] }
        .map { it.split("|") }
        .map { it -> it.map { it.split(" ").filter { it.isNotBlank() }.map { it.trim().toInt() } } }

        val cardList = inputLines.map { Card(it[0], it[1]) }

        val numberOfMatches = cardList.map { it.winningNumbers.toSet().intersect(it.playersNumbers.toSet()).size }.filter { it != 0 }

        val powersOf = numberOfMatches.map { powers(it) }.sum()

    return powersOf
//We have each line in a list
//    Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53
//    41 48 83 86 17 | 83 86  6 31 17  9 48 53
//    ["41 48 83 86 17", "83 86  6 31 17  9 48 53"]
//    [41, 48, 83, 86, 17], [83, 86,  6, 31, 17,  9, 48, 53]
//    4

}

data class Card(
    val winningNumbers: List<Int>,
    val playersNumbers: List<Int>
)

fun powers(power: Int): Double {
    return if (power == 1) 1.0 else (2.0).pow(power.toDouble() - 1)
}


