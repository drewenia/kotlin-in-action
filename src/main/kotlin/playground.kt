import java.io.BufferedReader
import java.io.StringReader

fun main() {
    val list = listOf(1, 2, 3)
    println(joinToString(list)) // [1, 2, 3]
    println(joinToString(list, seperator = "$ ")) // [1$ 2$ 3]
}

fun <T> joinToString(
    collection: Collection<T>,
    seperator: String = ", ",
    prefix: String = "[",
    postfix: String = "]"
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(seperator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}
