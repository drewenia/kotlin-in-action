import ch04.Person443v2
import kotlin.random.Random

fun main() {
    val json = """{ "name": "John Doe" }"""
    val person = Person.fromJSON(json)
    println("First name : ${person.firstName}, Last name : ${person.lastName}")
    // First name : John, Last name : Doe
}

// business logic module
class Person(val firstName : String, val lastName : String){
    // Boş bir companion object declare eder
    companion object
}

// client/server communication module
fun Person.Companion.fromJSON(json : String) : Person{
    val fullName = json
        .substringAfter("\"name\"")
        .substringAfter(":")
        .substringAfter("\"")
        .substringBefore("\"")

    val parts = fullName.split(" ", limit = 2)

    val firstName = parts.getOrElse(0) { "" }
    val lastName = parts.getOrElse(1) { "" }

    return Person(firstName, lastName)
}
