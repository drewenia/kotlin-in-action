fun main() {
    val people = listOf(
        Person("Derek", 26),
        Person("Jim", 29),
        Person("Ari", 21),
        Person("David", 43),
    )

    val canBeInClub27 = { p: Person -> p.age <= 27 }

    val (comeIn, stayOut) = people.partition(canBeInClub27)
    println(comeIn) // [Person(name=Derek, age=26), Person(name=Ari, age=21)]
    println(stayOut) // [Person(name=Jim, age=29), Person(name=David, age=43)]
}

data class Person(val name: String, val age: Int)

