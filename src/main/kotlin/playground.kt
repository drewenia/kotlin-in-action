fun main() {
    println(checkInRangeCollection()) // false
}

fun checkInRangeCollection() : Boolean = "Kotlin" in setOf("Java","Scala")

