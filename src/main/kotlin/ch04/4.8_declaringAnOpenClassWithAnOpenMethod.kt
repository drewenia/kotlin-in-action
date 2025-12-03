package ch04

/* Bir class için subclasses oluşturulmasına izin vermek istiyorsanız, class’ı open modifier ile işaretlemeniz gerekir.
Buna ek olarak, override edilebilmesini istediğiniz her property veya method’a da open modifier eklemeniz gerekir.
Diyelim ki kullanıcı arayüzünüzü basit bir butonun ötesine taşımak ve tıklanabilir bir RichButton oluşturmak
istiyorsunuz. Bu class’ın subclasses’ları kendi animasyonlarını sağlayabilmeli, ancak butonu devre dışı bırakmak gibi
temel davranışları bozamamalıdır. Class’ı şu şekilde deklarasyon yapabilirsiniz.
*/

open class RichButton : Clickable{
    fun disable(){
        // bu function finaldir subclass'da override edilemez
        println("button disabled")
    }
    open fun animate(){
        // bu function open olduğu için subclass tarafından override edilebilir
        println("rich button animated")
    }
    override fun click(){
        // bu function, open bir function'ı override eder ve kendiside open'dir
        println("RichButton was clicked")
    }
}

/* Bu, RichButton’ın bir subclass’ının da aşağıdaki gibi görünebileceği anlamına gelir. RichButton içinde disable
default olarak final olduğu için, burada onu override edemezsiniz.
*/
class ThemedButton : RichButton(){
    override fun animate(){
        println("Themed button animated")
    }

    override fun click(){
        println("ThemedButton was clicked")
    }

    // RichButton bir override sağlamamış olsa bile, showOff’u override edebilirsiniz.
    override fun showOff(){
        println("I am themedbutton and clickable")
    }
}

/* Dikkat edin, bir base class veya interface’in member'ini override ederseniz, override eden member varsayılan olarak
yine open olur. Eğer bunu değiştirmek ve class’ınızın subclasses’larının sizin implementasyonunuzu override etmesini
yasaklamak isterseniz, override eden member'i açıkça final olarak işaretleyebilirsiniz.
*/

open class RichButtonv2 : Clickable {
    final override fun click() {
        println("RichButton was clicked")
    }
}

/* Varsayılan olarak final olan class’ların önemli bir faydası, smart cast’lerin çok daha geniş senaryolarda
kullanılabilmesini sağlamalarıdır. Compiler bir smart cast’i (ek bir manuel cast gerektirmeden üyelerine erişmenizi
sağlayan otomatik cast) yalnızca type check’ten sonra değişmiş olma ihtimali olmayan variable’lar için yapabilir. Bir
class açısından bu, smart cast’lerin yalnızca bir class property’si hem val olup hem de custom accessor içermediğinde
kullanılabileceği anlamına gelir. Bu gereklilik property’nin final olmasını zorunlu kılar; çünkü aksi takdirde bir
subclass property’yi override ederek custom accessor tanımlayabilir ve smart cast’lerin temel gerekliliğini bozabilir.
Properties varsayılan olarak final olduklarından, smart cast’leri çoğu property ile hiç düşünmeden kullanabilirsiniz;
bu da kodunuzun ifade gücünü artırır.*/