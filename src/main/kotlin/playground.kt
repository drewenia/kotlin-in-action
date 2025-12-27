fun main() {
    val lastChar = "Hello".lastChar()
    println(lastChar) // o
}

// Burada String receiver type
// this -> Receiver object (Yani String)
fun String.lastChar() : Char = get(length -1)