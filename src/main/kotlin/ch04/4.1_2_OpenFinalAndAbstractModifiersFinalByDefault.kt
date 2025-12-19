package ch04

/* Varsayılan olarak, bir Kotlin class’ı için subclass oluşturamazsınız ve base class’tan herhangi bir method’u override
edemezsiniz — tüm class’lar ve method’lar varsayılan olarak final’dır. Bu durum, herhangi bir class’ın subclass’ını
oluşturmanıza izin verilen ve final keyword’üyle açıkça işaretlenmedikçe herhangi bir method’un override edilebildiği
Java’dan onu ayırır. Peki Kotlin neden bu yaklaşımı izlemedi? Çünkü bu çoğu zaman kullanışlı olsa da, aynı zamanda
problemli de olabilir. Sözde fragile base class problemi, bir base class’ta yapılan değişikliklerin, base class’ın
değişen kodunun artık subclass’larındaki varsayımlarla uyuşmaması nedeniyle subclass’ların hatalı davranışlar
sergilemesine yol açtığı durumda ortaya çıkar. Eğer class, nasıl subclass’lanması gerektiğine dair kesin kurallar
sağlamıyorsa (hangi method’ların override edilmesi gerektiği ve nasıl edileceği gibi), kullanıcılar base class’ın
yazarının beklemediği şekillerde method’ları override etme riskiyle karşı karşıya kalır. Tüm subclass’ları analiz etmek
imkânsız olduğundan, base class “fragile”dır; bu anlamda, üzerinde yapılan herhangi bir değişiklik subclass’larda
beklenmedik davranış değişikliklerine yol açabilir. Bu probleme karşı korunmak için, iyi Java programlama tarzı üzerine
en iyi bilinen kitaplardan biri olan Joshua Bloch’un *Effective Java*’sı (Addison-Wesley, 2008), “inheritance için
design ve document edin ya da onu yasaklayın” önerisinde bulunur. Bu, subclass’larda override edilmesi özel olarak
amaçlanmayan tüm class ve method’ların açıkça final olarak işaretlenmesi gerektiği anlamına gelir. Kotlin bu felsefeyi
izler ve class’larını, method’larını ve property’lerini varsayılan olarak final yapar. Bir class’ın subclass’larının
oluşturulmasına izin vermek istiyorsanız, class’ı open modifier ile işaretlemeniz gerekir. Ayrıca, override edilebilecek
her property ya da method için de open modifier eklemeniz gerekir. Basit bir button’ın ötesine geçip kullanıcı
arayüzünüzü zenginleştirmek ve clickable bir RichButton oluşturmak istediğinizi varsayalım. Bu class’ın subclass’ları
kendi animation’larını sağlayabilmeli, ancak button’ı devre dışı bırakmak gibi temel behavior’ı bozmamalıdır. Class’ı
aşağıdaki gibi declare edebilirsiniz. */

// Bu class open’dır: başkaları ondan inherit edebilir.
open class RichButton412 : Clickable411v2 {
    fun disable() {} // bu function finaldir. Subclass'dan override edilemez
    open fun animate () {} // bu function opendir. Subclass'dan override edilebilir

    // Bu function, open bir function’ı override eder ve kendisi de open’dır.
    override fun click() = println("Rich button clicked")
}

/* Bu, RichButton’ın bir subclass’ının sırasıyla aşağıdaki gibi görünebileceği anlamına gelir. */

class ThemedButton : RichButton412() {
    // disable, RichButton içinde varsayılan olarak final olduğu için, burada onu override edemezsiniz.
    // animate açıkça open olarak işaretlendiği için, onu override edebilirsiniz.
    override fun animate() {}
    // RichButton, click’i explicitly final olarak işaretlemediği için onu override edebilirsiniz.
    override fun click() {}
    // RichButton bir override sağlamamış olsa bile, showOff’u override edebilirsiniz.
    override fun showOff() {}
}

/* Bir base class ya da interface’in bir member’ını override ettiğinizde, override eden member varsayılan olarak open
olur. Bunu değiştirmek ve class’ınızın subclass’larının sizin implementation’ınızı override etmesini yasaklamak
istiyorsanız, override eden member’ı açıkça final olarak işaretleyebilirsiniz. */

open class RichButton412v2 : Clickable411v2{
    // Burada final redundant değildir, çünkü final olmadan override edilmesi, open olmayı ima eder.
    final override fun click() {}
}

/* Varsayılan olarak final olan class’ların önemli bir faydası, daha geniş bir senaryo yelpazesinde smart cast’lere
olanak tanımalarıdır. Compiler yalnızca type kontrolünden sonra değişmiş olamayacak variable’lar için smart cast (ek bir
manual cast yapmadan member’lara erişmenizi sağlayan otomatik bir cast) gerçekleştirebilir. Bir class için bu, smart
cast’lerin yalnızca val olan ve custom accessor’ı bulunmayan bir class property’siyle kullanılabileceği anlamına gelir.
Bu gereksinim, property’nin final olması gerektiği anlamına gelir; çünkü aksi takdirde bir subclass property’yi override
edebilir ve bir custom accessor tanımlayarak smart cast’lerin temel gereksinimini bozabilir. Property’ler varsayılan
olarak final olduğu için, çoğu property ile smart cast’leri bunu açıkça düşünmeden kullanabilirsiniz; bu da kodunuzun
expressiveness’ını artırır. */

/* Bir class’ı abstract olarak da declare edebilirsiniz; bu, class’ın instantiate edilememesi anlamına gelir. Abstract
bir class genellikle implementation’ı olmayan ve subclass’larda override edilmesi gereken abstract member’lar içerir.
Abstract member’lar her zaman open’dır; bu nedenle açık bir open modifier kullanmanız gerekmez (tıpkı bir interface’te
açık bir open modifier’a gerek olmaması gibi). Abstract bir class’a örnek olarak, animation’ın hızını ve frame sayısını
tanımlayan property’leri ve ayrıca animation’ı çalıştırmaya yönelik behavior’ı tanımlayan bir class verilebilir. Bu
property ve method’lar yalnızca başka bir object tarafından implement edildiğinde anlamlı olduğundan, Animated abstract
olarak işaretlenir. */

// Bu class abstract’tır: ondan bir instance oluşturamazsınız.
abstract class Animated412{
    /* Bu property abstract’tır: bir value’su yoktur ve subclass’ların value’sunu ya da accessor’ını override etmesi
    gerekir. */
    abstract val animationSpeed : Double

    /* Abstract class’lardaki property’ler varsayılan olarak open değildir, ancak explicitly open olarak
    işaretlenebilirler. */
    val keyframes : Int = 20
    open val frames : Int = 60

    /* Bu function abstract’tır: bir implementation’ı yoktur ve subclass’larda override edilmek zorundadır. */
    abstract fun animate()

    /* Abstract class’lardaki non-abstract function’lar varsayılan olarak open değildir, ancak bu şekilde
    işaretlenebilirler. */
    open fun stopAnimating () {}
    fun animateTwice() {}
}

/* img.png, Kotlin’deki access modifier’ları listeler. Tablodaki yorumlar class’lardaki modifier’lar için geçerlidir;
interface’lerde final, open veya abstract kullanmazsınız. Bir interface’teki member her zaman open’dır; final olarak
declare edemezsiniz. Body’si yoksa abstract’tır, ancak keyword’ün yazılması gerekmez. Inheritance’ı kontrol eden
modifier’ları ele aldığımıza göre, şimdi Kotlin’de visibility modifier’larının oynadığı role bakalım. */