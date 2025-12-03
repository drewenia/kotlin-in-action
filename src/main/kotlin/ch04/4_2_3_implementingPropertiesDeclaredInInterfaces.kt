package ch04

/* Kotlin’de bir interface, abstract property declaration’lar içerebilir. Böyle bir declaration içeren bir interface
tanımının bir örneği şöyledir:
*/

interface UserChapter4{
    val nickname : String
}

/* Bu, User interface’ini implement eden class’ların nickname değerini elde etmenin bir yolunu sağlaması gerektiği
anlamına gelir. Interface, değerin bir backing field’da mı saklanması yoksa bir getter aracılığıyla mı elde edilmesi
gerektiğini belirtmez. Dolayısıyla, interface’in kendisi herhangi bir state içermez. Interface’i implement eden
class’lar, ihtiyaç duyarlarsa değeri saklayabilir ya da erişildiğinde yalnızca compute edebilir. Interface için birkaç
olası implementation’a bakalım: Yalnızca nickname’ini dolduran PrivateUser; görünüşe göre kayıt olmak için bir email
address vermek zorunda kalan SubscribingUser; ve bir sosyal ağdaki account ID’sini düşünmeden paylaşan SocialUser. Bu
class’ların hepsi interface’teki abstract property’yi farklı şekillerde implement eder.
*/

// Primary constructor property
/* PrivateUser için, primary constructor içinde doğrudan bir property declare etmek üzere concise syntax kullanırsın.
Bu property, User’daki abstract property’yi implement ettiği için override olarak işaretlersin.
*/
class PrivateUser(override val nickname : String) : UserChapter4

/* SubscribingUser için, nickname property’si custom bir getter aracılığıyla implement edilir. Bu property, değerini
saklamak için bir backing field içermez; yalnızca her invocation’da email’den bir nickname hesaplayan bir getter’a
sahiptir.
*/
class SubscribingUser (val email : String) : UserChapter4 {
    override val nickname : String
        get() = email.substringBefore('@') // custom getter
}

/* SocialUser için, initializer içinde nickname property’sine değer assign edersin. Bu işlemde, account ID verildiğinde
bir sosyal kullanıcının adını döndürmesi gereken getNameFromSocialNetwork fonksiyonunu kullanırsın. Gerçek hayatta bu
fonksiyon maliyetlidir: İstenen data’yı almak için sosyal ağ sağlayıcısıyla bağlantı kurması gerekir. Bu yüzden,
initialization aşamasında onu bir kez invoke etmeye karar verirsin.
*/
class SocialUser (val accountId : Int) : UserChapter4{
    //  property initializer
    override val nickname = getNameFromSocialNetwork(accountId)
}

fun getNameFromSocialNetwork(accountId : Int) =
    "kodee$accountId"

fun main() {
    println(PrivateUser("kodee").nickname) // kodee
    println(SubscribingUser("test@kotlinlang.org").nickname) // test
    println(SocialUser(123).nickname) // kodee123
}

/* SubscribingUser ve SocialUser içindeki nickname implementation’larının farklılıklarına dikkat et. Benzer
görünmelerine rağmen, SubscribingUser’ın property’si her access’te substringBefore hesaplayan custom bir getter’a
sahiptir, oysa SocialUser içindeki property, class initialization sırasında compute edilen data’yı saklayan bir backing
field içerir. Abstract property declaration’lara ek olarak, bir interface, bir backing field’a referans vermedikleri
sürece getter ve setter’lara sahip property’ler içerebilir. (Bir backing field, bir interface içinde state saklamayı
gerektirir, bu da izin verilmez.) Bir örneğe bakalım:
*/

interface EmailUser{
    val email : String
    val nickname : String
        get() = email.substringBefore('@')
    // Property’nin bir backing field’ı yoktur: result değeri her access’te compute edilir.
}

/* Bu interface, abstract property olan email’i ve custom getter’a sahip nickname property’sini içerir. İlk property
subclass’larda override edilmek zorundadır, buna karşılık ikinci property inherit edilebilir (ya da gerektiğinde
override edilebilir).
*/

/* Ne zaman property’leri function’lara tercih etmeli Bir class’ın karakteristiklerinin genel olarak property olarak,
davranışlarının ise method olarak declare edilmesi gerektiğini belirtmiştik. Kotlin’de, function yerine read-only
property kullanmaya yönelik birkaç ek stil kuralı daha vardır. İlgili code aşağıdaki özelliklerden herhangi birine
sahipse, function yerine bir property tercih et:

-> Exception fırlatmaz
-> Hesaplaması ucuzdur (ya da ilk çalışmada cache edilir)
-> Object state değişmemişse birden fazla invocation’da aynı sonucu döndürür

Aksi durumda, bunun yerine bir function kullanmayı düşün.
*/

/* Interface’lerde implement edilen property’lerin aksine, class’larda implement edilen property’ler backing field’lara
tam erişime sahiptir.*/
