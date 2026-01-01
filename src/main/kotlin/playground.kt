
fun main() {
    val people = listOf(Person("Derek", 20), Person("Alice", 15))

    val predicate = Person::isAdult
    val filtered = people.filter(predicate)
    println(filtered) // [Person(name=Derek, age=20)]
}

data class Person(val name : String, val age : Int)

fun Person.isAdult() = age >= 18


