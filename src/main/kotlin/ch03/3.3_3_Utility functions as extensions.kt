package ch03

/* Artık joinToString function’ın final version’ını yazabilirsin. Bu, Kotlin standard library’de bulacağın hâliyle
neredeyse tamamen aynıdır. */

fun <T> Collection<T>.joinToString333(
    seperator: String = "#",
    prefix: String = "(",
    postfix: String = ")"
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(seperator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun main() {
    val list = listOf("Ocean", "Kuce", "11A")
    println(list.joinToString333()) // (Ocean#Kuce#11A)

    /* Onu element’lerden oluşan bir collection’a extension yaparsın (yani list’ler, set’ler ve benzerleri üzerinde
    çalışır) ve tüm argument’ler için default value’lar sağlarsın. Artık joinToString’ı bir class member’ı gibi invoke
    edebilirsin. */
    val list2 = listOf(1, 2, 3)
    println(list2.joinToString333(" ")) // (1 2 3)
    println(listOf("one", "two", "three").join333()) // -one..two..three£
    // listOf(1,2,8).join333() // çalışmaz
}

/* Extension function’lar effectively static method call’lar üzerinde syntactic sugar oldukları için, receiver type
olarak yalnızca bir class değil, daha spesifik bir type da kullanabilirsin. Diyelim ki yalnızca string collection’ları
üzerinde invoke edilebilen bir join function’a sahip olmak istiyorsun: */

fun Collection<String>.join333(
    seperator: String = "..",
    prefix: String = "-",
    postfix: String = "£"
) = joinToString333(seperator, prefix, postfix)

/* Extension’ların static doğası, extension function’ların subclass’larda override edilemeyeceği anlamına da gelir. */