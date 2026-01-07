import java.io.File

class Address(val streetAddress: String, val zipCode: Int, val city: String, val country: String)

class Company(val name : String, val address : Address?)

class Person(val name : String, val company : Company?)

fun Person.countryName() : String {
    // Birden fazla safe-call operator’ü zincir halinde kullanılabilir.
    val country = this.company?.address?.country
    return if (country != null) country else "Unknown"
}

fun main() {
    val person = Person("Dimitri",null)
    println(person.countryName()) // Unknown
}


// data class Person(val name: String, val age: Int)

