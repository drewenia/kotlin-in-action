fun main() {
    val people = listOf(
        Person("Joe", 22),
        Person("Mary", 31),
        Person("Jamie", 22)
    )

    val personToAge = people.associateWith { it.age }
    println(personToAge)
    // Joe ve Jamie aynı yaştalar
    // {Person(name=Joe, age=22)=22, Person(name=Mary, age=31)=31, Person(name=Jamie, age=22)=22}

    // key olarak kullanılmaktadır …
    val ageToPerson = people.associateBy { it.age }
    println(ageToPerson)
    // dolayısıyla map’te yalnızca ikincisi görünür.
    // {22=Person(name=Jamie, age=22), 31=Person(name=Mary, age=31)}
}

data class Person(val name: String, val age: Int)

