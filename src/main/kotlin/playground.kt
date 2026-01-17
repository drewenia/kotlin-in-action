data class Person(val name: String, val age: Int)

val people = listOf(
    Person("Alice", 29),
    Person("Bob", 31)
)

fun lookForAlice(people: List<Person>) {
    // Lambda expression yerine anonymous function kullanır
    people.forEach(fun(person) {
        if (person.name == "Alice") return // return, en yakın function’a refer eder: **anonymous function**.
        println("${person.name} is not Alice")
    })
}

fun main() {
    people.filter(fun(person) = person.age < 30)
}