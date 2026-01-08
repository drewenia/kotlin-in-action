// Artık T nullable olamaz.
fun <T : Any> printHashCode(t: T) {
    println(t.hashCode())
}

fun main() {
    // Bu code compile olmaz: non-null bir value beklendiği için null pass edemezsin.
    printHashCode(null) // null
}


// data class Person(val name: String, val age: Int)

