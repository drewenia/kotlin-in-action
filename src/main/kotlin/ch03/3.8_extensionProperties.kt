package ch03

/* Tıpkı extension function’lar gibi, extension property’ler de tanımlayabilirsiniz. Bunlar, class’ları function
syntax'ı yerine property syntax'ı kullanarak erişilebilen API’lerle extend etmenizi sağlar. Property olarak
adlandırılsalar da, herhangi bir state’e sahip olamazlar çünkü bunu saklayacak uygun bir yer yoktur—Java objelerinin
mevcut instance’larına ek field eklemek mümkün değildir. Bu nedenle, extension property’ler her zaman daha önce
öğrendiğiniz gibi özel accessor tanımlamak zorundadır. Yine de, daha kısa ve öz bir çağrı syntax'ı sağlarlar ve bu bazen
çok işe yarayabilir. Önceki bölümde lastChar() function’ını tanımladınız. Şimdi bunu bir property’ye dönüştürelim;
böylece "myText".lastChar() yerine "myText".lastChar şeklinde çağırabilirsiniz.*/

val String.lastChar: Char
    get() = this.get(length - 1)

/* Görüldüğü gibi, tıpkı function’larda olduğu gibi, bir extension property de receiver type eklenmiş normal bir
property gibi görünür. Getter her zaman tanımlanmalıdır çünkü bir backing field yoktur ve dolayısıyla varsayılan bir
getter implementasyonu da yoktur. Aynı nedenle initializer’lar da kullanılamaz; çünkü initializer ile belirtilen değeri
saklayacak bir yer yoktur. Aynı property’i StringBuilder üzerinde tanımlarsanız, içeriği değiştirilebilir olduğu için
bunu **var** yapabilirsiniz.*/

var StringBuilder.lastCharacter: Char
    get() = this.get(length - 1)
    set(value) {
        this.setCharAt(length - 1, value)
    }

// Extension property’lere, tıpkı member property’lere erişir gibi erişirsiniz:

fun main(){
    val sb = StringBuilder("Kotlin?")
    println(sb.lastCharacter) // ?
    sb.lastCharacter = '!'
    println(sb.lastCharacter) // !
}

/* Extension property’lere Java’dan erişmeniz gerektiğinde, getter ve setter’ı açıkça çağırmanız gerekir:
StringUtilKt.getLastChar("Java") ve StringUtilKt.setLastChar(sb, '!').*/