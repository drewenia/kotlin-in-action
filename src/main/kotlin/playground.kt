fun main() {
    println(checkPercentage(91)) // 91
}

fun checkPercentage(percentage: Int): Int {
    val number =
        if (percentage in 1..100) percentage
        else throw IllegalArgumentException("A percentage value must be between 0 and 100: $percentage")
    return number
}

