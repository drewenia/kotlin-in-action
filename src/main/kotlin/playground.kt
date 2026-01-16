fun <T> Collection<T>.joinToString(
    seperator: String = ", ",
    prefix: String = "#",
    postfix: String = "#",
    // Nullable bir function type türünde bir parameter declare eder
    transform: ((T) -> String)? = null
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(seperator)
        // Function’ı call etmek için safe-call syntax’ını kullanır
        val str = transform?.invoke(element)
            // Callback’in belirtilmediği durumu handle etmek için Elvis operator’ünü kullanır
            ?: element.toString()
        result.append(str)
    }
    result.append(postfix)
    return result.toString()
}

fun main() {
    val letters = listOf("Alpha", "Beta")

    // Default conversion function’ı kullanır
    println(letters.joinToString()) // #Alpha, Beta#

    // Argument olarak bir lambda geçirir
    println(letters.joinToString { it.lowercase() }) // #alpha, beta#

    // Bir lambda dahil olmak üzere birden fazla argument geçirmek için named argument syntax’ını kullanır
    println(letters.joinToString(seperator = "$", prefix = "∫", postfix = "∫", transform = { it.uppercase() }))
    // ∫ALPHA$BETA∫
}