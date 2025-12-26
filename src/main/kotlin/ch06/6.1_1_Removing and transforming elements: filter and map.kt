package ch06

/* filter ve map function’ları, collection’ları manipulate etmenin temelini oluşturur. Birçok collection operation’ı
bunların yardımıyla ifade edilebilir. Belirli bir predicate’e göre bir collection’ı filtreleme göreviyle karşılaştığında
ya da bir collection’daki her element’i farklı bir forma dönüştürmen gerektiğinde, bu function’lar aklına gelmelidir.
Her function için, sayılarla bir example ve tanıdık Person class’ını kullanan bir example sunacağız: */

data class Person611(val name: String, val age: Int)

/* filter function’ı bir collection boyunca ilerler ve verilen lambda’nın true döndürdüğü element’leri seçer. Örneğin,
bazı numbers’tan oluşan bir list verildiğinde, filter yalnızca çift olan numbers’ı (2’ye bölmenin remainder’ı 0 olanlar)
ayıklamana yardımcı olabilir: */

fun evenNumber611() {
    val list = (1..10).toList()
    println(list.filter { it % 2 == 0 }) // [2, 4, 6, 8, 10]
}

/* Sonuç, predicate’i sağlayan input collection’daki element’leri içeren yeni bir collection’dır; bu durum img.png’de
gösterilmiştir.*/

/* Yalnızca 30 yaşından büyük kişilerden oluşan bir collection istiyorsan, filter’ı yine kullanabilirsin: */

fun olderThan30611(){
    val people = listOf(
        Person611("Alice",29),
        Person611("Bob",31),
        Person611("Desire",46)
    )
    val olderThan30 = people.filter { it.age > 30}
    println(olderThan30) // [Person611(name=Bob, age=31), Person611(name=Desire, age=46)]
}

/* filter function, verilen bir predicate ile eşleşen element’lerden yeni bir collection oluşturabilir, ancak bu süreçte
element’leri transform etmez—çıktın hâlâ Person object’lerinden oluşan bir collection’dır. Bunu, type’larını
değiştirmeden collection’ından entry’leri “extract etmek” olarak düşünebilirsin. Bunu, input collection’daki
element’leri transform etmene olanak tanıyan map function ile karşılaştır. map, verilen function’ı collection’daki her
element’e uygular ve return value’ları yeni bir collection içinde toplar. Aşağıdaki example’da olduğu gibi, numbers’tan
oluşan bir list’i karelerinden oluşan bir list’e dönüştürmek için kullanabilirsin: */

fun mapFunctionExample611(){
    val list = (1..10).toList()
    val squares = list.map { it * it }
    println(squares) // [1, 4, 9, 16, 25, 36, 49, 64, 81, 100]
}

/* Sonuç, aynı sayıda element içeren yeni bir collection’dır, ancak her element verilen predicate function’a göre
transform edilmiştir (img_1.png ye bak). */

fun main() {
    evenNumber611()
    olderThan30611()
    mapFunctionExample611()
}