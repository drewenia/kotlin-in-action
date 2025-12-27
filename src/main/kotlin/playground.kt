import java.io.BufferedReader
import java.io.StringReader

fun main() {
    val list = listOf(1, 2, 3)
    val modifiedList = joinToString(list,"#","é","é")
    println(modifiedList) // é1#2#3é
}

fun <T> joinToString(
    collection: Collection<T>,
    seperator: String,
    prefix: String,
    postfix: String
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(seperator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}
