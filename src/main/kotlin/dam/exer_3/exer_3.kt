package dam.exer_3

import dam.exer_2.exer_2
import java.util.*
fun main() {
    val bounceHeights = generateSequence(100.0) { it * 0.6 }

    val qualifyingBounces = bounceHeights
        .takeWhile { it >= 1.0 }
        .take(15)
        .toList()

    val formattedBounces = qualifyingBounces.map { "%.2f".format(it) }
    println(formattedBounces)
}