package ch04

/* object keyword’ü yalnızca isimlendirilmiş singleton benzeri object’leri declare etmek için değil, aynı zamanda
anonymous object’leri declare etmek için de kullanılabilir. Anonymous object’ler, Java’daki anonymous inner class
kullanımının yerini alır. Örneğin, Kotlin’de tipik bir event listener’ı nasıl sağlayabileceğine bakalım. Diyelim ki,
kullanıcının button ile etkileşime girdiğinde davranışı belirlemek için MouseListener interface’inin bir instance’ını
alan bir Button class’ı ile çalışıyorsun: */

interface MouseListener444 {
    fun onEnter()
    fun onClick()
}

class Button444(private val listener : MouseListener444) {}

/* MouseListener interface’inin ad hoc bir implementation’ını oluşturmak için bir object expression kullanabilir ve
ardından bunu Button constructor’ına geçirebilirsin. */

fun main() {
    Button444(object : MouseListener444{
        override fun onEnter() {}
        override fun onClick() {}
    })

    val listener = object : MouseListener444 {
        override fun onEnter() {}
        override fun onClick() {}
    }

    /* Local bir variable declare eder */
    var clickCount = 0
    Button444(object : MouseListener444{
        override fun onEnter() {}
        override fun onClick() {
            // Variable’ın value’sunu update eder
            clickCount++
        }
    })
}

/* Syntax, object declaration’lar ile aynıdır; tek fark, object’in name’ini atlamandır. Ancak object declaration’ların
aksine, anonymous object’ler singleton değildir. Bir object expression her execute edildiğinde, object’in yeni bir
instance’ı oluşturulur. Object expression bir class declare eder ve o class’ın bir instance’ını oluşturur, ancak ne
class’a ne de instance’a bir isim atar. Genellikle buna gerek yoktur; çünkü object’i bir function call’unda parameter
olarak kullanırsın. Eğer object’e bir isim ataman gerekiyorsa, onu bir variable içinde saklayabilirsin: main method
içerisinde örneklendirdim (val listener) */

/* Kotlin’de anonymous object’ler oldukça esnektir: tek bir interface’i, birden fazla interface’i implement edebilirler
ya da hiçbir interface implement etmeyebilirler. Bir object expression içindeki code, oluşturulduğu function’daki
variable’lara erişebilir — tıpkı Java’daki anonymous class’larda olduğu gibi. Ancak Java’nın aksine, bu durum final
variable’larla sınırlı değildir. Kotlin’de, bir object expression içinden variable’ların value’larını da
değiştirebilirsin. Örneğin, bir listener kullanarak bir pencere içindeki click sayısını nasıl sayabileceğine bakalım.
main method içerisinde örneklendirdim (clickCount) */

/* Object expression’lar, anonymous object’inde birden fazla method override etmen gerektiğinde çoğunlukla faydalıdır.
Yalnızca tek method’lu bir interface’i (Runnable gibi) implement etmen gerekiyorsa, Kotlin’in SAM conversion desteğine
(tek bir abstract method’a sahip bir interface’in implementation’ına bir function literal dönüştürülmesi) güvenebilir ve
implementation’ını bir function literal (lambda) olarak yazabilirsin. */