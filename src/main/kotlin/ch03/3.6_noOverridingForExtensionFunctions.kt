package ch03

/* Kotlin’de method overriding, member function’lar için her zamanki gibi çalışır, ancak extension function’lar override
edilemez. Diyelim ki iki class’ınız var: **View** ve **Button**. **Button**, **View**’in subclass’ıdır ve
superclass’taki **click** function’ını override eder. Bunu gerçekleştirmek için, **View** ve **click**’i override’a izin
vermek amacıyla **open** ile işaretlersiniz ve subclass içinde bir implementasyon sağlamak için **override**
modifier’ını kullanırsınız
*/

open class View{
    open fun click() = println("View clicked")
}

class Button : View(){
    override fun click() = println("button clicked")
}

/* Eğer **View** type’ında bir variable declare ederseniz, bu variable’a **Button** type’ında bir değer atayabilirsiniz,
çünkü **Button**, **View**’in subtype’ıdır. Eğer bu variable üzerinde **click** gibi normal bir method’u çağırırsanız ve
bu method **Button** class’ında override edilmişse, **Button** class’ındaki override edilmiş implementasyon kullanılır:
*/
fun main() {
    val view : View = Button()
    view.click() // button clicked
}

/* Ama extension’lar için durum böyle değildir. Extension function’lar class’ın bir parçası değildir; dışarıda declare
edilirler. Bir base class ve onun subclass’ı için aynı isim ve parametre tiplerine sahip extension function’lar
tanımlayabilseniz de, çağrılan function, değişkenin compile zamanında belirlenen statik type’ına bağlıdır; değişkenin
içinde saklanan değerin run-time type’ına değil. Aşağıdaki örnek, View ve Button class’ları üzerinde declare edilmiş iki
showOff extension function’ını gösterir. Eğer bir View type’ındaki variable üzerinde showOff çağrılırsa, değerinin
gerçek tipi Button olsa bile, ilgili extension çağrılır.*/

fun View.showOff() = println("I'm a view!")
fun Button.showOff() = println("I'm a button!")

fun main2() {
    val view: View = Button()
    view.showOff() // I'm a view!
}

/* Gördüğünüz gibi, overriding extension function’lara uygulanmaz; Kotlin onları statik olarak resolve eder. Eğer class,
bir extension function ile aynı signature’a sahip bir member function içeriyorsa, member function her zaman
önceliklidir. Bunu, class’ların API’sini extending ederken akılda tutmalısınız: Eğer bir client’in tanımladığı
extension function ile aynı signature’a sahip bir member function eklerseniz ve client kodunu yeniden derlerse, anlam
değişir ve artık yeni member function’a referans verir. IDE’niz de extension function’ın bir member function tarafından
gölgelendiği (shadowed) konusunda sizi uyaracaktır. */
