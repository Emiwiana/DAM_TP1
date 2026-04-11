package dam.exer_2

import java.lang.Exception
import java.util.*

fun main (args: Array<String>) {
    val scanner = Scanner(System.`in`)
    println("=============================================" +
            "\n         Welcome to the Calculator" +
            "=============================================")
    exer_2().startCalculator(scanner)
}
class exer_2 {
    fun arithmeticOperations(scanner: Scanner): Double {
        println("Please insert the values and operator for the operation." +
                "\n Valid Operators: '+', '-', '/' '*'" +
                "\n Value 1:")

        val val1 = scanner.next().toDoubleOrNull() ?: throw IllegalArgumentException("Input Value must be Numeric")
        println("Operator:")
        val operator = scanner.next()
        println("Value 2:")
        val val2 = scanner.next().toDoubleOrNull() ?: throw IllegalArgumentException("Input Value must be Numeric")

        return when(operator){
            "+" -> val1 + val2
            "-" -> val1 - val2
            "/" -> {
                if (val2 == 0.0) throw IllegalArgumentException("Division by 0.")
                val1.div(val2)
            }

            "*" -> val1 * val2
            else -> throw IllegalArgumentException("Invalid operator.")
        }
    }

    fun booleanOperations(scanner: Scanner): Int {
        println("Please insert the values and operator for the operation." +
                "\n Valid Operators: 'and', 'or', 'not'" +
                "\n Value 1:")

        val val1 = scanner.next().toIntOrNull() ?: throw IllegalArgumentException("Input Value must be Numeric")
        println("Operator:")
        val operator = scanner.next().lowercase(Locale.getDefault())
        return if(operator == "not"){
            val1.inv()
        } else {
            println("Value 2:")
            val val2 = scanner.next().toIntOrNull() ?: throw IllegalArgumentException("Input Value must be Numeric")
            when(operator){
                "and" -> val1 and val2
                "or"  -> val1 or val2
                else -> throw IllegalArgumentException("Invalid operator.")
            }
        }
    }

    fun bitwiseShiftOperations(scanner: Scanner): Int {
        println("Please insert the value, operator and number of bits to shift for the operation." +
                "\n Valid Operators: 'shl', 'shr'" +
                "\n Value:")
        val value = scanner.next().toIntOrNull() ?: throw IllegalArgumentException("Input Value must be Numeric")
        println("Operator:")
        val operator = scanner.next().lowercase(Locale.getDefault())
        println("Number of Bits to shift:")
        val num = scanner.next().toIntOrNull() ?: throw IllegalArgumentException("Input Value must be Numeric")
        return when(operator){
            "shl" -> value.shl(num)
            "shr" -> value.shr(num)
            else -> throw IllegalArgumentException("Invalid operator.")
        }
    }
    @OptIn(ExperimentalStdlibApi::class)
    fun displayResult(result: Double){
        println(result)
        println(result.toInt().toHexString())
        when(result.toInt()){
            1 -> println("True")
            0 -> println("False")
            else -> println("The result can not be converted to boolean")
        }
    }
    fun startCalculator(scanner: Scanner){
        println("\n Please select the mode you would like to use by typing it's number" +
                "\n 1. Arithmetic Operations" +
                "\n 2. Boolean Operations" +
                "\n 3. Bitwise Shift Operations" +
                "\n 4. Quit")
        val selection = scanner.next()
        var result = 0.0
        when(selection) {
            "1" -> {
                println("Arithmetic Mode Selected!");
                try {
                    result = arithmeticOperations(scanner)
                    displayResult(result)
                } catch (e: IllegalArgumentException) {
                    println(e.localizedMessage)
                } finally {
                    startCalculator(scanner)
                }
            }
            "2" -> {
                println("Boolean Mode Selected!");
                try {
                    result = booleanOperations(scanner).toDouble()
                    displayResult(result)
                } catch (e: IllegalArgumentException) {
                    println(e.localizedMessage)
                } finally {
                    startCalculator(scanner)
                }
            }
            "3" -> {
                println("Bitwise Shift Mode Selected!");
                try {
                    result = booleanOperations(scanner).toDouble()
                    displayResult(result)
                } catch (e: IllegalArgumentException) {
                    println(e.localizedMessage)
                } finally {
                    startCalculator(scanner)
                }
            }
            "4" -> { println("Have a nice day!");  }
            else ->{ println("Invalid Option. Please select from one of the modes."); startCalculator(scanner)}
        }



    }
}