fun main() {
    val processed = hashSetOf(Customer("Alice", 74100))
    println(processed.contains(Customer("Alice", 74100))) // false
}

class Customer(val name: String, val postalCode: Int) {
    override fun toString() = "Customer (name : $name, postalcode : $postalCode)"

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Customer) return false

        return name == other.name && postalCode == other.postalCode
    }

    override fun hashCode(): Int = name.hashCode() * 31 + postalCode
}