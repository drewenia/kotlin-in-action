package ch03

/* Artık element’lerden oluşan bir collection oluşturmayı bildiğine göre, basit bir şey yapalım: içeriğini print edelim.
Bu aşırı derecede basit görünüyorsa endişelenme; bu süreçte birçok önemli concept ile karşılaşacaksın. Java
collection’larının default bir toString implementasyonu vardır, ancak output’un format’ı sabittir ve her zaman ihtiyaç
duyduğun şey olmayabilir. */

fun printList32() {
    val list = listOf(1, 2, 3)
    println(list) // [1, 2, 3]
}

/* Element’lerin default implementasyonun kullandığı köşeli parantezler yerine noktalı virgüllerle ayrılmış ve
parantezlerle çevrelenmiş olmasını istediğini hayal et: (1; 2; 3). Bunu çözmek için Java project’leri Guava ve Apache
Commons gibi third-party library’ler kullanır ya da logic’i project içinde yeniden implement eder. Kotlin’de ise bunu
handle eden bir function standard library’nin bir parçasıdır. */

/* Bu bölümde, bu function’ı kendin implement edeceksin. Kotlin’in function declaration’larını basitleştiren
olanaklarını kullanmayan, straightforward bir implementasyonla başlayacak ve ardından onu daha idiomatic bir stile
yeniden yazacaksın. Bir sonraki kısımda gösterilen joinToString function’ı, collection’ın element’lerini aralarında bir
separator olacak şekilde, başta bir prefix ve sonda bir postfix ile bir StringBuilder’a (mutable bir karakter
sequence’i) ekler. Bu function generic’tir; herhangi bir type’tan element içeren collection’lar üzerinde çalışır.
Generic’ler için syntax Java’ya benzerdir. */

fun <T> joinToString32 (
    collection : Collection<T>,
    seperator : String,
    prefix : String,
    postfix : String
) : String{
    val result = StringBuilder(prefix)
    for((index,element) in collection.withIndex()){
        if (index > 0) result.append(seperator) // İlk element’ten önce bir separator ekleme.
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun main() {
    val list = listOf(1,2,3)
    println(joinToString32(list,";","(",")")) // (1;2;3)
}

/* Implementasyon iyi durumda ve büyük ölçüde olduğu gibi bırakacaksın. Bunun yerine, declaration’a odaklanacağız—bu
function’ın call edilmesini nasıl daha az verbose hale getirebilirsin? Belki function’ı her call ettiğinde dört argument
geçirmek zorunda kalmaktan kaçınabilirsin. Neler yapabileceğine bakalım. */