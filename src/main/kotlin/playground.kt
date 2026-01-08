fun main() {
    yellAtSafe(Person(null))
}

fun yellAtSafe(person : Person){
    println((person.name ?: "Anyone").uppercase())
}


data class Person(val name : String)
// data class Person(val name: String, val age: Int)

