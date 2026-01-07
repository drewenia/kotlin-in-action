import java.io.File

fun strLenSafe(s: String?): Int =
    if (s != null) s.length else 0

fun main() {
    val x : String? = null
    val strLenSafe = strLenSafe(x)

    println(strLenSafe) // 0
    println(strLenSafe("abc")) // 3
}


data class Person(val name: String, val age: Int)

