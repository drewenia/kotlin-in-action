fun main() {
    alsoExample()
}

fun alsoExample() {
    val fruitList = listOf("apple", "banana", "cherry")
    val upperCase = mutableListOf<String>()
    val reservedList = fruitList
        .map { it.uppercase() }
        .also { upperCase.addAll(it) }
        .filter { it.length > 5 }
        .also { println(it) }
        .reversed()

    println(upperCase)
    println(reservedList)
}

