package ch03

fun main() {
    val strings : List<String> = listOf("first", "second", "fourteenth")
    println(strings.last()) // fourteenth

    val numbers : Collection<Int> = setOf(1,14,2)
    println(numbers.sum()) // 17
}


/* last ve sum fonksiyonları extension function olarak tanımlanmıştır ve Kotlin dosyalarınıza varsayılan olarak import
edilir! last fonksiyonu, önceki bölümde String için gördüğünüz lastChar örneğinden daha karmaşık değildir; List için
tanımlanmış bir extension’dır. sum fonksiyonu için de (gerçek kütüphane versiyonu Int dışındaki number türlerinde de
çalışır ama burada sadeleştirilmiş bir declaration verilir):*/

// fun<T> List<T>.last() : T {}
// fun Collection<Int>.sum() : Int {}
