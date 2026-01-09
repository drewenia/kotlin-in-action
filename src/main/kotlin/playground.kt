import kotlin.test.assertEquals

fun main() {
    val theName: String? = "Ari"
    val theNumber: Int? = 7

    val result = theName?.let { name ->
        theNumber?.let { num -> "Hi $name, $num squared is ${num * num}" }
    }

    println(result) // Hi Ari, 7 squared is 49
}

open class Animal

class Dog : Animal() {
    fun bark() = println("Woof")
}

fun makeItBark(animal: Animal) {
    (animal as? Dog)?.bark()
}


// data class Person(val name: String, val age: Int)

