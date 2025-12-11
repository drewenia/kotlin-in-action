package ch02

/* Kotlin’de while ve do-while loop’ları vardır ve syntax’ları muhtemelen diğer programlama dillerinden sana tanıdık
gelecektir. */

/*
while (condition) {
    /*...*/
    if (shouldExit) break
}

do {
    if (shouldSkip) continue
    /*...*/
} while (condition)
*/

/* Inner loop’lar için, Kotlin break veya continue kullanırken referans verebileceğin bir label belirtmene izin verir.
Bir label, **@** işaretini takip eden bir identifier’dır. */

/*
outer@ while (outerCondition) {
    while (innerCondition) {
        if (shouldExitInner) break
        if (shouldSkipInner) continue
        if (shouldExit) break@outer
        if (shouldSkip) continue@outer
        // ...
    }
}
*/

fun main() {
    //print("Lutfen sayi giriniz : ")
    //val num = readln().toInt()
    //whileDo241(num)
    //whileDo241v2()
    outerLoop241()
}

fun whileDo241(num : Int){
    var i = num
    do{
        println("i : $i")
        i--
    }while (i>=0)
}

fun whileDo241v2(){
    do{
        println("1. Başlat")
        println("2. Ayarlar")
        println("3. Çıkış")
        val choice = readln().toInt()
        when(choice) {
            1 -> println("Başlatılıyor")
            2 -> println("Ayarlar")
            3 -> println("Çıkış")
            else -> println("geçersiz seçim")
        }
    } while(choice != 3)
}

fun outerLoop241(){
    outer@ for (i in 1..3){
        for (j in 1..3){
            println("i=${i} j=${j}")
            if (j == 2) break@outer
        }
    }
}

/*  i=1 j=1
    i=1 j=2
*/