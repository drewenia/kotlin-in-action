fun main() {
    plus10(11)
}

fun plus10(score: Int?) {
    val plus10 = score?.plus(10)
    println("Plus 10 : $plus10") // Plus 10 : 21
}

// data class Person(val name: String, val age: Int)

