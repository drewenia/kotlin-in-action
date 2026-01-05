fun main() {
    val people = listOf(
        Person("Derek", 31),
        Person("Jim", 24),
        Person("Ari", 21),
        Person("David", 43),
    )

    val canBeInClub27 = { p: Person -> p.age <= 27 }
    val find = people.find(canBeInClub27)
    println(find) // Person(name=Jim, age=24)
}

data class Person(val name: String, val age: Int)

