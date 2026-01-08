fun main() {
    val p1 = Person("Dimitri", "Jemerov")
    val p2 = Person("Dimitri", "Jemerov")

    println(p1 == null) // false
    println(p1 == p2) // true
    println(p1.equals(42)) // false
}

class Person(val firstName: String, val lastName: String) {
    override fun equals(other: Any?): Boolean {
        // Type’ı check eder ve eşleşme yoksa false return eder.
        val otherPerson = other as? Person ?: return false

        // Safe-cast’ten sonra, otherPerson variable’ı Person type’ına smart cast edilir.
        return otherPerson.firstName == firstName &&
                otherPerson.lastName == lastName
    }

    override fun hashCode(): Int = firstName.hashCode() * 31 + lastName.hashCode()
}


// data class Person(val name: String, val age: Int)

