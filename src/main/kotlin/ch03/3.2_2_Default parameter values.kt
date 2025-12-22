package ch03

/* Java’da sıkça rastlanan bir diğer problem, bazı class’larda aşırı sayıda overloaded method bulunmasıdır. Sadece
java.lang.Thread’a ve sekiz constructor’una bak! Overload’lar, geriye dönük uyumluluk, API kullanıcılarının kolaylığı
veya başka sebeplerle sağlanabilir, ama sonuç aynıdır: duplication. Parameter isimleri ve type’ları tekrar tekrar
yazılır ve kapsamlı olmak istiyorsan, her overload’da çoğu dokümantasyonu da tekrarlaman gerekir. Aynı zamanda, bazı
parameter’ları atlayan bir overload’ı çağırırsan, bu parameter’lar için hangi value’ların kullanıldığı her zaman net
değildir. Kotlin’de, function declaration’ında parameter’lar için default value belirtebildiğin için çoğu zaman overload
oluşturmaktan kaçınabilirsin. Bunu joinToString function’ını geliştirmek için kullanalım. Çoğu durumda, string’ler
herhangi bir prefix veya postfix olmadan virgüllerle ayrılabilir. Bu nedenle, bu değerleri default yapalım. */

fun <T> joinToString322(
    collection: Collection<T>,
    seperator: String = ", ",
    prefix: String = "#",
    postfix: String = "#"
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(seperator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

/* Artık function’ı tüm argument’lerle çağırabilir veya bazılarını atlayabilirsin: */

fun main() {
    val list = listOf(1, 2, 3)
    println(joinToString322(list)) // #1, 2, 3#
    println(joinToString322(list,"D","(",")")) // (1D2D3)
    println(joinToString322(list,prefix = "Z",seperator = "+")) // Z1+2+3#
}

/* Normal call syntax’ını kullanırken, argument’leri function declaration’daki sırayla belirtmen gerekir ve yalnızca
trailing argument’leri atlayabilirsin. Named argument’ları kullanırsan, parameter list’in ortasındaki bazı argument’leri
atlayabilir ve yalnızca ihtiyacın olanları, istediğin sırayla belirtebilirsin: */

/* Parametrelerin default value’larının, call edilen function’da encode edildiğini, call site’da olmadığını unutma. Eğer
default value’yu değiştirir ve function’ı içeren class’ı yeniden compile edersen, parameter için bir value belirtmemiş
olan caller’lar yeni default value’yu kullanmaya başlar. */

/* Java’da default parameter value kavramı olmadığından, default parameter value’lu bir Kotlin function’ı Java’dan
çağırırken tüm parameter value’larını açıkça belirtmen gerekir. Eğer bir function’ı Java’dan sıkça çağırman gerekiyorsa
ve Java caller’lar için kullanımını kolaylaştırmak istiyorsan, function’ı @JvmOverloads ile annotate edebilirsin. Bu,
compiler’a Java overloaded method’lar üretmesini söyler; parametreleri, sonuncudan başlayarak teker teker atlar.
Örneğin, joinToString function’ını aşağıdaki gösterildiği gibi @JvmOverloads ile annotate edebilirsin. */

@JvmOverloads
fun <T> joinToString322v2(
    collection: Collection<T>,
    seperator: String = ", ",
    prefix: String = "#",
    postfix: String = "#"
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(seperator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

/* Bu, aşağıdaki overload’ların oluşturulduğu anlamına gelir: */

/* Java */
/*

String joinToString(Collection<T> collection, String separator, String prefix, String postfix);
String joinToString(Collection<T> collection, String separator, String prefix);
String joinToString(Collection<T> collection, String separator);
String joinToString(Collection<T> collection);

*/