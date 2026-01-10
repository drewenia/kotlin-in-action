fun readNumbers(text: String): List<Int?> =
    text.lineSequence()
        .map { it.toIntOrNull() }
        .toList()

fun addValidNumbers(numbers: List<Int?>) {
    val validNumbers = numbers.filterNotNull()

    println("Sum of valid numbers : ${validNumbers.sum()}") // Sum of valid numbers : 124
    println("Invalid numbers : ${numbers.size - validNumbers.size}") // Invalid numbers : 2
}

fun main() {
    val testString = """
        10
        twenty
        30
        61
        23
        sixty
    """.trimIndent()

    val numbers = readNumbers(testString)
    addValidNumbers(numbers)
}

