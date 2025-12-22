package ch02
import ch02.Color231v2.*

/* Kotlin’deki when yapısı, diğer dillerde alışık olabileceğinden daha esnektir — bir branch koşulu olarak herhangi bir
türde object kullanabilirsin. Bu küçük palette karıştırılabiliyorlarsa iki rengi karıştıran bir function yazalım. Çok
fazla seçeneğin yok ve hepsini kolayca enumerate edebilirsin. */

fun mix (c1: Color231v2, c2: Color231v2) =
    /* Bir when expression’ının argümanı herhangi bir object olabilir. Branch koşullarıyla eşitlik açısından kontrol
    edilir. */
    when(setOf(c1,c2)) {
        /* Karıştırılabilen renk pair’larını enumerate eder. */
        setOf(RED,YELLOW) -> ORANGE
        setOf(YELLOW,BLUE) -> GREEN
        setOf(BLUE, VIOLET) -> INDIGO
        /* Diğer branch’lerin hiçbiri eşleşmediğinde çalıştırılır. */
        else -> throw Exception("Dirty color")
    }

fun main() {
    println(mix(BLUE,YELLOW))
}

/* Eğer renkler c1 ve c2 RED ve YELLOW ise (ya da tam tersi), onları karıştırmanın sonucu ORANGE’dır ve devamı da buna
göredir. Bunu gerçekleştirmek için set karşılaştırması kullanırsın. Kotlin standart library’si, argüman olarak verilen
object’leri içeren bir Set oluşturan setOf isimli bir function içerir. Bir set, item’ların sırasının önemli olmadığı bir
collection’dır; iki set, aynı item’ları içeriyorsa eşittir. Dolayısıyla setOf(c1, c2) ve setOf(RED, YELLOW) set’leri
eşitse, ya c1 RED ve c2 YELLOW’dur ya da tam tersidir. Bu da tam olarak kontrol etmek istediğin şeydir. When
expression’ı, argümanını bir branch koşulu sağlanana kadar sırayla tüm branch’lerle karşılaştırır. Dolayısıyla
setOf(c1, c2), önce setOf(RED, YELLOW) ile ve ardından diğer renk setleriyle, birbiri ardına eşitlik açısından kontrol
edilir. Diğer branch koşullarının hiçbiri sağlanmazsa, else branch’i değerlendirilir. Kotlin compiler’ı, tüm olası color
set kombinasyonlarını kapsadığımızı çıkaramadığı için ve when expression’ının sonucu mix function’ının return value’su
olarak kullanıldığından, when expression’ının gerçekten eksiksiz olmasını garanti etmek adına bir varsayılan case
sağlamaya mecburuz. */