package ch02

/* Bir value’nun bir range içinde olup olmadığını kontrol etmek için **in** operator’ünü, bir range içinde
**olmamasını** kontrol etmek için ise karşıtı olan **!in’i** kullanırsın. Örneğin, bir kullanıcının input’unu
doğrularken, çoğu zaman bir input karakterinin gerçekten bir letter olup olmadığını ya da digit’leri exclude edip
etmediğini kontrol etmen gerekir. İşte bir karakterin bir karakter range’ine ait olup olmadığını kontrol eden bazı
küçük helper function’lar—isLetter ve isNotDigit—yazmak için **in’i** nasıl kullanabileceğin.
*/

fun isLetter244(c: Char) = c in 'a'..'z' || c in 'A' .. 'Z'
fun isNotDigit244(c: Char) = c !in '0' .. '9'

fun main(){
    println(isLetter244('9')) // false
    println(isNotDigit244('C')) // true
    println(recognize244('A')) // It's a letter
    checkInRange244() // true
    checkInRangeCollection244() // false
}

/* Bir karakterin letter olup olmadığını kontrol etmek için kullanılan bu teknik basit görünür. İç tarafta herhangi bir
trick olmaz: karakterin kodunun, ilk letter’ın kodu ile son letter’ın kodu arasında bir yerde olup olmadığını hâlâ
kontrol edersin. Ancak bu logic, standard library’deki range class’larının implementasyonunda özlü bir şekilde
gizlenmiştir. */

/*
c in 'a'..'z' <- Transforms to 'a' <= c && c <= 'z'
*/

/* In ve !in operator’leri, when expression’larında da çalışır; bu da kontrol etmek istediğin birden fazla farklı
range olduğunda işleri daha da kullanışlı hale getirir. */

fun recognize244 (c : Char) = when(c) {
    in '0'..'9' -> "It's a digit"
    in 'a'..'z', in 'A'..'Z' -> "It's a letter"
    else -> "I dont know"
}

/* Range’ler sadece karakterlerle sınırlı değildir. Instance’ları compare etmeyi destekleyen herhangi bir class varsa,
o type’ın object’lerinden oluşan range’ler oluşturabilirsin. Böyle bir range’in varsa, range içindeki tüm object’leri
enumerate edemezsin. Bir düşün: örneğin Java ve Kotlin arasında alfabetik olarak bulunan tüm string’leri enumerate
edebilir misin? Hayır, edemezsin. Ancak yine de başka bir object’in range’e ait olup olmadığını in operator’ünü
kullanarak kontrol edebilirsin. */

fun checkInRange244(){
    println("Kotlin" in "Java".."Scala")
}

/* String’ler burada alfabetik olarak compare edilir, çünkü String class’ı Comparable interface’ini bu şekilde
implement eder. Alfabetik sort’ta "Java", "Kotlin"’den önce gelir ve "Kotlin", "Scala"’dan önce gelir, dolayısıyla
"Kotlin" bu iki string arasında yer alan range’in içindedir. Aynı in kontrolü collection’larla da çalışır. */

fun checkInRangeCollection244(){
    println("Kotlin" in setOf("Java","Scala")) // Bu set "Kotlin" string’ini içermez.
}
