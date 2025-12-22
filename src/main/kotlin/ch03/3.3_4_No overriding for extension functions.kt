package ch03

/* Kotlin’de method overriding, member function’lar için her zamanki gibi çalışır, ancak bir extension function’ı
override edemezsin. Diyelim ki View ve Button olmak üzere iki class’ın var. Button, View’un bir subclass’ıdır ve
superclass’taki click function’ını override eder. Bunu implement etmek için, overriding’e izin vermek üzere View ve
click’i open modifier ile işaretlersin ve subclass’ta bir implementation sağlamak için override modifier’ını
kullanırsın. */

open class View334{
    open fun click() = println("View clicked")
}

class Button334 : View334(){
    override fun click() = println("Button clicked")
}

/* Type’ı View olan bir variable declare edersen, Button, View’un bir subtype’ı olduğu için bu variable içinde Button
type’ında bir value saklayabilirsin. Bu variable üzerinde click gibi normal bir method call edersen ve bu method Button
class’ında override edilmişse, Button class’ındaki overridden implementation kullanılır. */

fun main() {
    val view : View334 = Button334()
    view.click() // Button clicked

    val view2 : View334 = Button334()
    /* Extension function statically resolve edilir. */
    view2.showOff() // I am a view

}

/* Ancak extension’lar için bu şekilde çalışmaz. Extension function’lar class’ın bir parçası değildir; img.png’de
gösterildiği gibi, class’ın dışında declared edilirler. Bir base class ve onun subclass’ı için aynı isim ve parameter
type’lara sahip extension function’lar define edebilsen bile, çağrılan function, variable’ın declared static type’ına
bağlıdır; bu, compile time’da belirlenir ve variable içinde saklanan value’nun run-time type’ına bağlı değildir.
Aşağıdaki örnek, View ve Button class’ları üzerinde declared edilmiş iki showOff extension function’ı gösterir. Type’ı
View olan bir variable üzerinde showOff call ettiğinde, value’nun gerçek type’ı Button olsa bile, karşılık gelen View
extension’ı çağrılır. Main function'unun da görüldüğü gibi. */

fun View334.showOff() = println("I am a view")
fun Button334.showOff() = println("I am a button")

/* Bir extension function’ın, receiver’ı ilk argument olan bir static function olarak Java’ya compile edildiğini
hatırlamak yardımcı olabilir. Java da function’ı aynı şekilde seçer.

class Demo {
    public static void main(String[] args) {
        View view = new Button();
        ExtensionsKt.showOff(view);
        // I'm a view!
    }
}
*/

/* Gördüğün gibi, overriding extension function’lar için geçerli değildir; Kotlin onları statically resolve eder. Bir
class, bir extension function ile aynı signature’a sahip bir member function içeriyorsa, member function her zaman
önceliklidir. Class’ların API’sini genişletirken bunu aklında tutmalısın: class’ına, bir client’ın tanımlamış olduğu bir
extension function ile aynı signature’a sahip bir member function eklersen ve client kodunu yeniden compile ederse,
kodun anlamı değişir ve yeni member function’a referans vermeye başlar. IDE’n de extension function’ın bir member
function tarafından shadow edildiği konusunda seni uyarır. External class’lar için ek method’lar sağlamayı ele aldık.
Şimdi aynı şeyi property’lerle nasıl yapabileceğimize bakalım. */