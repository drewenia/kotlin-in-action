fun main() {
    val blankName = " "
    println(blankName.ifEmpty { "(unnamed)" }) //
    println(blankName.ifBlank { "(unnamed)" }) // unnamed
}

data class Person(val name: String, val age: Int)

