fun main() {
    val temperatures = listOf(27.7, 29.8, 22.0, 35.5, 19.1)
    val chunked = temperatures.chunked(2)
    println(chunked) // [[27.7, 29.8], [22.0, 35.5], [19.1]]

    val summed = temperatures.chunked(2) { it.sum() }
    println(summed) // [57.5, 57.5, 19.1]
}

data class Person(val name: String, val age: Int)

