fun main() {
    val numbers = mapOf(
        0 to "Zero",
        1 to "One",
        2 to "Two"
    )

    val filterKeys = numbers
        .filterKeys { it > 1 }
    println(filterKeys) // {2=Two}

    val mapKey = numbers
        .mapKeys { "ID: ${it.key}"}
    println(mapKey) // {ID: 0=Zero, ID: 1=One, ID: 2=Two}
}

data class Person(val name: String, val age: Int)

