import kotlin.test.assertEquals

fun main() {
    val answer : String? = "42"
    val answerToInt = answer!!.toInt()
    println(answerToInt) // 42
}

open class Animal

class Dog : Animal() {
    fun bark() = println("Woof")
}

fun makeItBark(animal: Animal) {
    (animal as? Dog)?.bark()
}


// data class Person(val name: String, val age: Int)

