package ch03

fun main() {
    // kotlin'in collection'ları default olarak read-only'dir
    val set = setOf(1, 7, 53)
    val list = listOf(1, 7, 53)
    val map = mapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

    println(set.javaClass) // java'nın getClass() ina eşittir
    println(list.javaClass)
    println(map.javaClass)

    /* bir list’in son element’ini alabilir, listenin karışık bir versiyonunu elde edebilir veya bir collection’ı
    toplayabilirsiniz (eğer bir number collection’ı ise).*/
    val strings = listOf("first", "second", "fourteenth")
    val numbers = setOf(1, 14, 2)
    println(strings.last()) // fourteenth
    println(strings.shuffled())
    println(numbers.sum())
}