package dam.exer_3

import dam.exer_2.exer_2
import java.util.*
fun main (args: Array<String>) {
    var startingHeight = 100.0


    val heights = generateSequence (100.0) { it * 0.6 }.takeIf {it > 1}

    heights.take(15).toList().forEach { print("$it ")}
    }

class exer_3 {
}