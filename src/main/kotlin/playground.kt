fun main() {
    val alice = Person("Alice",14)
    val derek = Person("Derek",33)

    // UNBOUND -> CLASS üzerinden referans
    val unBoundRef : (Person) -> Boolean = Person::isAdult

    // Nesneyi elle vermelisin
    println(unBoundRef(alice)) // false
    // Nesneyi elle vermelisin
    println(unBoundRef(derek)) // true

    // BOUND: Object üzerinden referans
    val boundRef : () -> Boolean = alice::isAdult
    // Nesne vermene gerek yok, o zaten 'alice'e bağlı!
    println(boundRef()) // false
}

data class Person(val name: String, val age: Int)

fun Person.isAdult() = age >= 18


