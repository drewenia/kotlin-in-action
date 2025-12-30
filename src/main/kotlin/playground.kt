fun main() {
    val alice = Customer("Alice",11700)
    val bob = alice.copy(name = "Bob")
    println(bob) // Customer(name=Bob, postalCode=11700)
}

data class Customer(val name : String,val postalCode: Int)