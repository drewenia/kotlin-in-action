package ch04

/* Bir class’ı abstract olarak da deklarasyon yapabilirsiniz; bu, class’ın instance oluşturulamaz olduğu anlamına gelir.
Abstract bir class genellikle implementasyonu olmayan ve subclasses tarafından override edilmesi gereken abstract
member'lar içerir. Abstract member'lar her zaman open’dır, bu yüzden explicit bir open modifier kullanmanız gerekmez
(tıpkı bir interface’te explicit open modifier gerekmediği gibi). Abstract bir class’a örnek olarak, bir animasyonun
hızını, frame sayısını ve animasyonu çalıştırma davranışını tanımlayan bir class verilebilir. Bu property ve method’lar
ancak başka bir object tarafından implement edildiğinde anlamlı oldukları için, Animated abstract olarak
işaretlenmiştir.*/

abstract class Animated{
    /* Bu property abstract’tır: bir değeri yoktur ve subclasses, değerini veya accessor’ını override etmek
    zorundadır.*/
    abstract val animationSpeed : Double

    /* Abstract class’lardaki properties varsayılan olarak open değildir, ancak açıkça open olarak
    işaretlenebilirler.*/
    val keyframes : Int = 20
    open val frames : Int = 60

    /*Bu fonksiyon abstract’tır: bir implementasyonu yoktur ve subclasses içinde override edilmelidir.*/
    abstract fun animate()

    /* Abstract class’lardaki non-abstract fonksiyonlar varsayılan olarak open değildir, ancak bu şekilde
    işaretlenebilirler. */
    open fun stopAnimating() = println("animate stopped")
    fun animateTwice() = println("animated twice")
}
