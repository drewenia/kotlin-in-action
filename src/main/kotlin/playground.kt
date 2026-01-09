fun main() {
    val animal = Animal()

    // Hiçbir şey olmaz (Crash olmaz çünkü as? null döndürür)
    makeItBark(animal)

    val animal2 = Dog()
    makeItBark(animal2) // Woof
}

open class Animal

class Dog : Animal() {
    fun bark() = println("Woof")
}

fun makeItBark(animal: Animal) {
    (animal as? Dog)?.bark()
}


// data class Person(val name: String, val age: Int)

