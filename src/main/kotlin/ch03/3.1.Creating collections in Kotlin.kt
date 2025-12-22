package ch03

/* Collection’ları ilginç şekillerde kullanabilmeden önce, onları nasıl oluşturacağını öğrenmen gerekir. Bölüm 2’de,
yeni bir set oluşturma yöntemine (item’ların sırasının önemli olmadığı bir collection—iki set, aynı item’ları içeriyorsa
eşittir) rastlamıştın: setOf function’ı. O zaman bir color set’i oluşturmuştun, ancak şimdilik işi basit tutalım ve
number’larla çalışalım. */

fun collectionExample31() {
    val set = setOf(1, 7, 53)

    // Bir list ya da bir map’i de benzer bir şekilde oluşturursun:
    val list = listOf(1, 7, 53)
    val map = mapOf(1 to "one", 7 to "seven", 53 to "fifty")
}

/* to’nun özel bir construct değil, normal bir function olduğunu unutma. Bu konuya chapter’ın ilerleyen kısmında, tekrar
döneceğiz. Burada hangi object class’larının oluşturulduğunu tahmin edebilir misin? Bunu kendin görmek için aşağıdaki
example’ı çalıştır. */

fun main() {
    val set = setOf(1, 7, 53)
    val list = listOf(1, 7, 53)
    val map = mapOf(1 to "one", 7 to "seven", 53 to "fifty")

    // javaClass -> javada'ki getClass()'a eşdeğerdir
    println(set.javaClass) // class java.util.LinkedHashSet
    println(list.javaClass) // class java.util.Arrays$ArrayList
    println(map.javaClass) // class java.util.LinkedHashMap
    collectionExample31v2()
}

/* Gördüğün gibi, Kotlin standart Java collection class’larını kullanır. Bu, Java developer’ları için iyi bir haberdir:
Kotlin collection class’larını yeniden implement etmez. Java collection’ları hakkındaki mevcut tüm bilgin burada da
geçerlidir. Ancak, Java’dan farklı olarak Kotlin’in collection interface’lerinin default olarak read only olduğunu
belirtmek gerekir. Standart Java collection’larını kullanmak, Java code’u ile etkileşimi çok daha kolay hale getirir.
Kotlin’den Java function’larını call ettiğinde ya da tam tersi durumda, collection’ları bir yönden diğerine convert
etmen gerekmez. Kotlin’in temel collection’ları Java collection’larıyla tamamen aynı class’lar olmasına rağmen,
Kotlin’de onlarla çok daha fazlasını yapabilirsin. Örneğin, bir list’ten son element’i alabilir, bir list’in shuffled
bir versiyonunu elde edebilir ya da (number’lardan oluşan bir collection olması koşuluyla) bir collection’ı
toplayabilirsin. */

fun collectionExample31v2() {
    val strings = listOf("first", "second", "fourteenth")
    println(strings.last()) // fourteenth
    println(strings.shuffled()) // shuffle edilir [second, fourteenth, first]

    val numbers = setOf(1, 14, 2, 1)
    println(numbers.sum()) // 2 adet 1 olduğu için birleştirilir 17 sonucunu verir
}

/* Bu chapter’da bunun nasıl çalıştığını ve Java class’ları üzerindeki tüm yeni method’ların nereden geldiğini
ayrıntılı olarak inceleyeceğiz. İlerleyen chapter’larda, lambda’lardan bahsetmeye başladığımızda, collection’larla
neler yapabileceğini çok daha fazla göreceksin; ancak aynı standart Java collection class’larını kullanmaya devam
edeceğiz. Ayrıca bölüm 8’de, Java collection class’larının Kotlin type system’inde nasıl represent edildiğini
öğreneceksin. Java collection’ları üzerinde doğrudan çalışabilen last ve sum function’larının nasıl çalışabildiğini
tartışmadan önce, function declare etmek için bazı yeni concept’leri öğrenelim. */