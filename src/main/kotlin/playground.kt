fun main() {
    val sb = StringBuilder("Kotlin?")
    println(sb.lastChar) // ?
    sb.lastChar = '!'
    println(sb.lastChar) // !
}

fun <T> List<T>.last() : T {

}