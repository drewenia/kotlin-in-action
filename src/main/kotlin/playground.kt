import kotlin.io.path.fileVisitor

data class Person(val name: String, val age: Int)

val people = listOf(
    Person("Alice", 29),
    Person("Bob", 31),
)

fun main() {
    val filteredAndMapping = people.filter { it.age > 30 }.map(Person::name)
    println(filteredAndMapping) // [Bob]
}