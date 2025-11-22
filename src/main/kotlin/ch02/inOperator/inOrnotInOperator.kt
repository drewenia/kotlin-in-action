package ch02.inOperator

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
fun isNotDigit(c: Char) = c !in '0'..'9'
fun recognize(c: Char) = when (c) {
    in '0'..'9' -> "it'a a digit"
    in 'a'..'z', in 'A'..'Z' -> "its a letter"
    else -> "i dont know"
}

fun main() {
    println(isLetter('c'))
    println(isNotDigit('d'))
    println(recognize('1'))

    /*
    Ranges karakterlerle sınırlı değildir. kotlin.Comparable interface’ini implement eden herhangi bir sınıfın varsa,
    o sınıfa ait object’ler için de range oluşturabilirsin. Böyle bir range’in varsa, içindeki tüm object’leri sırayla
    enumerate edemezsin. Bir düşün: alfabetik olarak Java ile Kotlin arasında kalan tüm string’leri tek tek
    sayabilir misin? Hayır, sayamazsın. Ama yine de başka bir object’in bu range’e ait olup olmadığını in operatörünü
    kullanarak kontrol edebilirsin. String’ler burada alfabetik olarak karşılaştırılır; çünkü String sınıfı Comparable
    interface’ini bu şekilde implement eder. Alfabetik sıralamada "Java", "Kotlin"’den önce gelir ve "Kotlin",
    "Scala"’dan önce gelir; dolayısıyla "Kotlin", iki string arasındaki range’in içindedir.
    */
    println("Kotlin" in "Java".."Scala")
    println("Kotlin" in setOf("Java","Scala"))
}