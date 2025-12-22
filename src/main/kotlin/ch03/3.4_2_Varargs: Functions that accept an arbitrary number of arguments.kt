package ch03

/* Bir list oluşturmak için bir function call ettiğinde, ona herhangi bir sayıda argument geçebilirsin:

val list = listOf(2,3,5,7,11)

Bu function’ın standard library’de nasıl declared edildiğine bakarsan, aşağıdaki signature’ı bulursun:

fun listOf<T>(vararg values: T): List<T> { /* implementation */ }
*/

/*Bu method, arbitrary sayıda value’yu bir array içinde paketleyerek bir method’a geçirmeni sağlayan bir language
feature’dan yararlanır: vararg. Kotlin’deki vararg’lar Java’dakilere benzerdir, ancak syntax biraz farklıdır: type’tan
sonra üç nokta yerine, Kotlin parameter üzerinde vararg modifier’ını kullanır. Kotlin ile Java arasındaki bir diğer
fark, geçirmen gereken argument’lerin zaten bir array içinde paketlenmiş olduğu durumda function call etme syntax’ıdır.
Java’da array’i olduğu gibi geçirirsin; Kotlin ise array’i açıkça unpack etmeni ister, böylece array’in her element’i
call edilen function’a ayrı bir argument olur. Bu feature spread operator olarak adlandırılır ve kullanımı, ilgili
argument’in önüne * karakterini koymak kadar basittir. Bu snippet’te, main function’ına geçirilen command-line
argument’leri içeren args array’ini “spreading” yaparak, onu listOf function’ı için variable argument’ler olarak
kullanıyorsun. */

fun main(args: Array<String>) {
    val list = listOf("args : ", *args) // * Spread operator, array’in contents’ini unpack eder.
    println(list)
}

/* Bu örnek, spread operator’ün bir array’den gelen value’ları ve bazı sabit value’ları tek bir call içinde
birleştirmeni sağladığını gösterir. Bu, Java’da desteklenmez. */