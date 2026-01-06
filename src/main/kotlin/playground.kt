import kotlin.math.PI

fun main() {
    val people = listOf(
        Person("Alex", 21),
        Person("Derek", 39),
        Person("Dimitri", 28),
        Person("Ari", 41),
    )

    val list = mutableListOf<Int>()
    for (i in 1..10_000_000) {
        list.add(i)
    }
    val toList = list
        .asSequence()
        .map { it * it.plus(2) }
        .filter { (it % 2) != 0 }
        .toList()
    println(toList)
}

data class Person(val name: String, val age: Int)

