import java.io.BufferedReader
import java.io.StringReader

fun main() {
    collection()
}

fun collection() {
    val strings = listOf("first", "second", "fourteenth")
    println(strings.last()) // fourteenth
    println(strings.shuffled()) // [second, fourteenth, first]

    val numbers = setOf(1, 14, 2, 1, 14)
    println(numbers.sum()) // 17 -> 2 adet 1 ve iki adet 14 olduğu için birleştirilir 17 sonucunu verir
}
