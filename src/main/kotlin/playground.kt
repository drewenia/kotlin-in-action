import javax.swing.text.View
import kotlin.math.exp

fun main() {
    val list = listOf(
        Person("Alice", 30),
        Person("Bob", 40)
    )
    println(findTheOldest(list)) // Person(name=Bob, age=40)
}

fun findTheOldest(peoples: List<Person>): Person? {
    return peoples.maxByOrNull(Person::age)
}

data class Person(val name: String, val age: Int)
