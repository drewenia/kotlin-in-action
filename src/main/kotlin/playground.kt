import java.io.File

class Address(val streetAddress: String, val zipCode: Int, val city: String, val country: String)

class Company(val name: String, val address: Address?)

class Person(val name: String, val company: Company?)

fun printShippingLabel(person: Person) {
    val address = person.company?.address ?: throw IllegalArgumentException("No address")
    with(address) {
        println(streetAddress)
        println("$zipCode $city, $country")
    }
}

fun main() {
    val address = Address("Elsestr. 47", 80687, "Munich", "Germany")
    val jetbrains = Company("JetBrains", address)
    val person = Person("Dimitri",jetbrains)
    val person2 = Person("Alexey",null)

    printShippingLabel(person)
    // Elsestr. 47
    // 80687 Munich, Germany

    printShippingLabel(person2) // java.lang.IllegalArgumentException: No address
}


// data class Person(val name: String, val age: Int)

