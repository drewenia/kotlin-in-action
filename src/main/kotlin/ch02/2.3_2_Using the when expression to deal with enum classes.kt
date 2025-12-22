package ch02

/* Gökkuşağının renklerini ezberlemek için çocukların kullandığı mnemonik ifadelerden herhangi birini hatırlıyor musun?
İşte bir tane: *Richard Of York Gave Battle In Vain!* Diyelim ki her renk için sana bir mnemonic veren bir function’a
ihtiyacın var (ve bu bilgiyi enum içinde saklamak istemiyorsun). Java’da bunun için bir switch statement kullanabilir
ya da Java 13’ten itibaren bir switch expression yazabilirdin. Buna karşılık gelen Kotlin yapısı ise **when**’dir. If
gibi, when de bir değer döndüren bir expression’dır, bu yüzden expression body kullanan ve doğrudan when expression’ını
döndüren bir function yazabilirsin. Bölümün başında function’lardan bahsederken, expression body’li çok satırlı bir
function örneği göstereceğimize söz vermiştik. Aşağıdaki code bu tür bir örneği gösterir. */

fun getMnemonic232(color : Color231) =
    when(color) {
        Color231.RED -> "Richard"
        Color231.ORANGE -> "Of"
        Color231.YELLOW -> "York"
        Color231.GREEN -> "Gave"
        Color231.BLUE -> "Battle"
        Color231.INDIGO -> "In"
        Color231.VIOLET -> "Vain"
    }

/* Kod, verilen color value’suna karşılık gelen branch’i bulur; her branch için break yazmana gerek olmadığını unutma.
(Java’da bir switch statement içinde break eksikliği sıkça bug’lara neden olur.) Bir eşleşme başarılı olduğunda yalnızca
ilgili branch çalıştırılır. Virgülle ayırarak bir branch içinde birden fazla value da birleştirebilirsin. Bu nedenle,
rengin “warmth” derecesine göre farklı branch’ler kullanmak istersen, enum constant’larını when ifaden içinde buna göre
gruplayabilirsin.
*/

fun measureColor232(color : Color231v2) : String{
    return when(color) {
        Color231v2.RED, Color231v2.ORANGE, Color231v2.YELLOW -> "warm (red = ${color.r})"
        Color231v2.GREEN -> "neutral (green = ${color.g}"
        Color231v2.BLUE, Color231v2.INDIGO, Color231v2.VIOLET -> "cold (blue = ${color.b})"
    }
}

fun main() {
    println(getMnemonic232(Color231.RED)) // Richard
    println(measureColor232(Color231v2.INDIGO))
}