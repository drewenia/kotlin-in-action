package ch03

fun main() {
    /* Java collection’ların varsayılan bir toString implementasyonu vardır, ancak output’un formatı sabittir ve her
    zaman ihtiyacınız olan şekilde değildir. */
    val list = listOf(1, 2, 3)
    println(list)
    println(joinToString(list,"; ","(", ")"))
    // (1; 2; 3)
}


/* Aşağıda gösterilen joinToString function’ı, collection’ın element’lerini aralarına bir separator koyarak, başında
bir prefix ve sonunda bir postfix olacak şekilde bir StringBuilder’a (mutable karakter sequence) ekler. Function
generic’tir; herhangi bir type’a sahip element’ler içeren collection’lar üzerinde çalışır. Generic syntax’ı Java’ya
benzer. Bu function çağrılarını daha az verbose hâle getirmek için nasıl değiştirebilirsiniz? Belki function’ı her
çağırdığınızda dört argument geçirme zorunluluğundan kaçınabilirsiniz */
fun <T> joinToString(
    collection : Collection<T>,
    seperator : String,
    prefix : String,
    postfix : String
) : String {
    val result = StringBuilder(prefix)
    for ((index,element) in collection.withIndex()){
        if (index > 0) result.append(seperator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}