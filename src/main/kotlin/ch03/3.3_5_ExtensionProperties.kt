package ch03

/* Kotlin property’lerini declare etme syntax’ını zaten öğrendin ve extension function’larda olduğu gibi extension
property’ler de belirtebilirsin. Bunlar, class’ları function syntax’ı yerine property syntax’ı kullanılarak erişilebilen
API’lerle genişletmene olanak tanır. Property olarak adlandırılsalar da herhangi bir state’e sahip olamazlar, çünkü bunu
saklayacak uygun bir yer yoktur—mevcut Java object instance’larına ekstra field’lar eklemek mümkün değildir. Sonuç
olarak, extension property’ler her zaman, öğrendiğin gibi custom accessor’lar tanımlamak zorundadır. Yine de, daha kısa
ve daha özlü bir call biçimi sunarlar ve bu da bazen işe yarayabilir. Önceki bölümde lastChar() adlı bir function
tanımlamıştın. Şimdi bunu bir property’ye dönüştürelim; böylece "myText".lastChar() yerine "myText".lastChar şeklinde
call edebilirsin. */

val String.lastChar335: Char
    get() = this.get(length - 1)

val String.lastChar355v2: Char
    get() = this[length - 1]

/* Gördüğün gibi, function’larda olduğu gibi, bir extension property de receiver type eklenmiş normal bir property gibi
görünür. Getter her zaman tanımlanmak zorundadır çünkü backing field yoktur ve dolayısıyla default bir getter
implementasyonu da yoktur. Aynı nedenle initializer’lara izin verilmez: initializer olarak belirtilen value’yu
saklayacak bir yer yoktur. Aynı property’yi bir StringBuilder üzerinde define edersen, StringBuilder’ın içeriği
değiştirilebildiği için onu var yapabilirsin. */

var StringBuilder.lastchar335: Char
    get() = this[length - 1]
    set(value) {
        this.setCharAt(length - 1, value)
    }

/* Extension property’lere, member property’lerle tamamen aynı şekilde erişirsin: */

fun main() {
    val sb = StringBuilder("Kotlin?")
    println(sb.lastchar335) // ?
    sb.lastchar335 = '!'
    println(sb.lastchar335) // !
}

/* Bir extension property’ye Java’dan erişmen gerektiğinde, getter ve setter’ını açıkça call etmen gerektiğini unutma:
StringUtilKt.getLastChar("Java") ve StringUtilKt.setLastChar(sb, '!'). */