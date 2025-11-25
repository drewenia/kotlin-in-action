package ch03

/* Bunu bir element collection’ına extension olarak tanımlıyorsunuz (yani list, set vb. üzerinde çalışır) ve tüm
argümanlar için varsayılan değerler sağlıyorsunuz. Artık joinToStringFinal’i bir class üyesi gibi çağırabilirsiniz */
fun <T> Collection<T>.joinToStringFinal(
    seperator: String = ", ",
    prefix: String = "",
    postfix: String = "",
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(seperator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

/* Extension function’lar aslında static method çağrılarının syntatic sugar'ları olduğu için, sadece bir class değil,
daha spesifik bir type’ı da receiver type olarak kullanabilirsiniz. Diyelim ki, yalnızca string collection’ları üzerinde
çağrılabilen bir join function’ı istiyorsunuz:*/
fun Collection<String>.join(
    seperator : String = ", ",
    prefix : String = "(",
    postfix : String = ")"
) = joinToStringFinal(seperator,prefix,postfix)

fun main() {
    val list = listOf(1, 2, 4)
    val stringList = listOf("One", "Two", "Three")
    println(list.joinToStringFinal("; ","#","#"))
    println(stringList.join())
}

/* Extension’ların static yapısı, extension function’ların subclass’larda override edilemeyeceği anlamına da gelir. */