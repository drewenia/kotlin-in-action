import kotlin.math.PI

fun main() {
    val people = listOf(
        Person("Alice", 29),
        Person("Bob", 31),
        Person("Charles", 31),
        Person("Dan", 21)
    )

    val firstMap = people
        .asSequence()
        .map(Person::name)
        .filter { it.length < 4 }
        .toList()

    val filterFirst = people
        .asSequence()
        .filter { it.name.length < 4 }
        .map(Person::name)
        .toList()

    println(firstMap) // [Bob, Dan]
    println(filterFirst) // [Bob, Dan]
}

data class Person(val name: String, val age: Int)

