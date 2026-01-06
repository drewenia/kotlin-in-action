fun main() {
    val names = listOf("Joe", "Mary", "Jamie")
    val ages = listOf(22, 31, 31, 44, 0)
    val countries = listOf("DE", "NL", "US")

    println(names zip ages zip countries) // [((Joe, 22), DE), ((Mary, 31), NL), ((Jamie, 31), US)]
}

data class Person(val name: String, val age: Int)

