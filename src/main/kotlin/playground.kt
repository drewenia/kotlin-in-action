fun main() {
    // compile olmaz
    // listOf(1,2,3).join()
}

fun <T> Collection<T>.joinToString(
    seperator: String = ", ",
    prefix: String = "(",
    postfix: String = ")"
): String {
    val result = StringBuilder(prefix)
    // this burada Collection'dır
    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(seperator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun Collection<String>.join(
    seperator: String = "..",
    prefix: String = "-",
    postfix: String = "£"
) = joinToString(seperator,prefix,postfix)
