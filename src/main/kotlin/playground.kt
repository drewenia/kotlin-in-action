fun main() {
    val names = mutableListOf("Martin", "Samuel")
    names.replaceAll { it.uppercase() }
    println(names) // [MARTIN, SAMUEL]

    names.fill("Redacted")
    println(names) // [Redacted, Redacted]
}

data class Person(val name: String, val age: Int)

