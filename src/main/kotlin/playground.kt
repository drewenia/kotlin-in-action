data class Person(
    val name: String,
    val age: Int? = null
) {
    fun isOlderThan(other: Person): Boolean? {
        if (age == null || other.age == null)
            return null
        return age > other.age
    }
}

data class People(
    val name: String,
    val age: Int? = null
) {
    fun isOlderThan(other: People): Boolean? {
        return age?.let { currentAge ->
            other.age?.let { otherAge ->
                currentAge > otherAge
            }
        }
    }
}

fun main() {
    val people1 = People("Dimitri", 16)
    val people2 = People("Ari",19)

    println(people1.isOlderThan(people2)) // false
    println(People("Jax").isOlderThan(People("Jamie",21))) // null
}




