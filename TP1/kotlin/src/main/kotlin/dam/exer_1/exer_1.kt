package dam.exer_1

fun main (args: Array<String>) {
    exer_1().perfectSquaresIntArray().forEach { print("$it ")}
    print("\n")
    exer_1().perfectSquaresRangeMap().forEach { print("$it ")}
    print("\n")
    exer_1().perfectSquaresArray().forEach { print("$it ")}
}
class exer_1 {
    fun perfectSquaresIntArray(): IntArray{
        return IntArray(50) { ((it + 1).times(it + 1))}
    }

    fun perfectSquaresRangeMap(): List<Int> {
        return (1..50).toList().map { it.times(it) }
    }

    fun perfectSquaresArray(): Array<Int> {
        return Array(50) {((it + 1).times(it + 1))}
    }
}