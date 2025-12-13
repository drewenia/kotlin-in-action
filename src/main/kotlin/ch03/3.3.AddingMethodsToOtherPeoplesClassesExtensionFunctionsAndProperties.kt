package ch03

/* Kotlin’in ana temalarından biri, mevcut code ile sorunsuz entegrasyondur. Tamamen Kotlin project’leri bile JDK,
Android framework ve diğer third-party framework’ler gibi Java library’leri üzerine inşa edilir. Ayrıca Kotlin’i bir
Java project’ine entegre ettiğinde, Kotlin’e dönüştürülmemiş ya da dönüştürülmeyecek mevcut code ile de çalışırsın.
Bu API’lerle çalışırken, onları yeniden yazmak zorunda kalmadan Kotlin’in sunduğu tüm kolaylıkları kullanabilmek güzel
olmaz mıydı? Extension function’lar tam olarak bunu yapmanı sağlar. Kavramsal olarak, extension function basit bir
şeydir: Bir class’ın member’ıymış gibi call edilebilen, ancak onun dışında define edilen bir function. Bir örnek
göstermek için, bir string’in son karakterini hesaplayan bir method ekleyelim (şimdilik empty string’lerle çalışma
edge case’ini göz ardı ederek): */

// String -> Receiver type -- this - this -> Receiver object
fun String.lastChar33(): Char = this.get(this.length - 1)
fun String.lastChar33v2(): Char = this[this.length - 1]

/* Yapman gereken tek şey, eklediğin function’ın adından önce, extend ettiğin class ya da interface’in adını koymaktır.
Bu class adı receiver type olarak adlandırılır; extension function’ı call ettiğin value ise receiver object olarak
adlandırılır. Receiver object bu type’ın instance’ıdır. */

fun main() {
    println("Kotlin".lastChar33v2()) // n
    println("Ocean".lastChar33v3()) // n
}

/* Bu örnekte, String receiver type’tır ve "Kotlin" receiver object’tir. Bir anlamda, String class’ına kendi method’unu
eklemiş oldun. String senin code’unun bir parçası olmasa ve hatta o class’ın source code’una sahip olmasan bile,
project’inde ihtiyaç duyduğun method’larla onu yine de genişletebilirsin. String’in Java, Kotlin ya da Groovy gibi başka
bir JVM language’ında yazılmış olması ya da subclassing’i engelleyen final olarak işaretlenmiş olması bile önemli
değildir. Java class’ına compile edildiği sürece, o class’a kendi extension’larını ekleyebilirsin. Bir extension
function’ın body’sinde, this’i bir method’ta kullandığın şekilde kullanırsın. Ve normal bir method’ta olduğu gibi,
onu atlayabilirsin: */

fun String.lastChar33v3(): Char = get(length - 1)

/* Extension function içinde, genişlettiğin class’ın method ve property’lerine, sanki class’ın kendisinde tanımlanmış
method’lar gibi doğrudan erişebilirsin. Ancak extension function’ların encapsulation’ı bozmasına izin verilmediğini
unutma. Class içinde tanımlanmış method’ların aksine, extension function’lar class’ın private veya protected
member’larına erişemez. İleride, hem class member’ları hem de extension function’lar için method terimini kullanacağız.
Örneğin, extension function’ın body’sinde receiver üzerinde herhangi bir method’u call edebileceğini söyleyebiliriz;
bu, hem member’ları hem de extension function’ları call edebileceğin anlamına gelir. Call site’da extension
function’lar, member’lardan ayırt edilemez ve çoğu zaman belirli bir method’un member mı yoksa extension mı olduğu
önemli değildir. */