package ch04

/* Bu, click adlı tek bir abstract method içeren bir interface deklarasyonu yapar ve bu method herhangi bir değer
döndürmez. Interface’i implement eden tüm non-abstract classes, bu methodun bir implementasyonunu sağlamalıdır. Teknik
olarak bir değer döndürür: Java’daki void’in Kotlin karşılığı olan Unit. Bunun ayrıntılarına daha sonra bakacağız
*/

interface Clickable{
    fun click()
    fun showOff() = println("I'm clickable!")
}

/* Kotlin, class adından sonra gelen iki noktayı hem composition (yani interfaces implement etme) hem de inheritance
(yani subclassing) için kullanır. Bir class istediği kadar interface implement edebilir, ancak yalnızca bir class’ı
extend edebilir. Override modifier, superclass veya interface’ten gelen method ve property’leri override edenleri
işaretlemek için kullanılır. Java’da isteğe bağlı olan @Override annotation’dan farklı olarak, Kotlin’de override
modifier’ının kullanılması zorunludur. Bu, implementasyonunuzu yazdıktan sonra bir method eklenirse yanlışlıkla
override etmenizi engeller; methodu açıkça override olarak işaretlemediğiniz veya yeniden adlandırmadığınız sürece
kodunuz compile olmaz. Bir interface method’u varsayılan bir implementasyona sahip olabilir. Bunu yapmak için sadece bir
method body sağlamanız yeterlidir. Bu durumda, Clickable interface’ine basitçe biraz metin yazdıran varsayılan bir
implementasyona sahip bir showOff fonksiyonu ekleyebilirsiniz.
*/

class ButtonV1 : Clickable{
    override fun click() = println("I was clicked")
}

/* Şimdi, başka bir interface’in de bir showOff method’u tanımladığını ve onun için aşağıdaki implementasyona sahip
olduğunu varsayalım.*/

interface Focusable{
    fun setFocus(b: Boolean) =
        println("I ${if(b) "got" else "lost"} focus.")

    fun showOff() = println("I'm focusable!")
}

/* Peki class’ınızda her iki interface’i de implement etmeniz gerekirse ne olur? Her birinde varsayılan bir
implementasyona sahip bir showOff method’u bulunur, peki hangi implementasyon kazanır? Hiçbiri kazanmaz. showOff’u
açıkça implement etmezseniz, compiler hatasını alırsınız. Class 'Button', birçok implementasyonunu miras aldığı için
public open fun showOff() fonksiyonunu override etmelidir. Kotlin compiler, kendi implementasyonunuzu sağlamanızı
zorunlu kılar. Burada, super ifadesinin köşeli parantezlerde bir supertype adıyla nitelenmiş olması, çağırmak
istediğiniz method’un hangi parent’a ait olduğunu belirtir.
*/

class Buttonv2 : Clickable, Focusable {
    override fun click() = println("I was clicked")

    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}

/* Eğer yalnızca miras alınan tek bir implementasyonu çağırmanız gerekiyorsa, expression body sözdizimini kullanarak
şunu yazabilirsiniz:*/

// override fun showOff() = super<Clickable>.showOff()

/* Button class’ınızın bir instance’ını oluşturabilir ve tüm miras alınan method’ları çağırabilirsiniz—override edilmiş
showOff ve click fonksiyonlarının yanı sıra, varsayılan bir implementasyon sağlayan Focusable interface’indeki setFocus
fonksiyonunu da.*/

fun main() {
    val button = Buttonv2()
    button.showOff()
    //I'm clickable!
    //I'm focusable!

    button.setFocus(true) // I got focus.
    button.click() // I was clicked
}

/* Kotlin, default method’lara sahip her interface’i, bir regular interface ile method body’lerini static method olarak
içeren bir class’ın birleşimine derler. Interface yalnızca declaration’ları içerir ve class, tüm implementasyonları
static method olarak barındırır. Bu nedenle, böyle bir interface’i bir Java class’ında implement etmeniz gerekirse,
Kotlin’de method body’si olsa bile tüm method’lar için kendi implementasyonlarınızı tanımlamanız gerekir. Örneğin,
Clickable’ı implement eden bir JavaButton, Kotlin’in ikincisi için varsayılan bir implementasyon sağlamasına rağmen,
hem click hem de showOff için implementasyon sunmak zorundadır; bu durum java klasöründe ch04 package'i içerisinde ki
JavaButton class'ında gösterilmiştir
*/
