package ch04

/* Kotlin’de bir interface, abstract property declaration’ları içerebilir. İşte böyle bir declaration’a sahip bir
interface tanımına örnek: */

interface User423{
    val nickname : String
}

/* Bu, User interface’ini implement eden class’ların nickname value’sunu elde etmenin bir yolunu sağlaması gerektiği
anlamına gelir. Interface, bu value’nun bir backing field’da mı saklanacağı yoksa bir getter aracılığıyla mı elde
edileceğini belirtmez. Bu nedenle, interface’in kendisi herhangi bir state içermez. Interface’i implement eden
class’lar, ihtiyaç duyarlarsa value’yu saklayabilir ya da erişildiğinde onu basitçe compute edebilirler. Interface için
birkaç olası implementation’a bakalım: yalnızca nickname’ini dolduran PrivateUser; kayıt olmak için görünüşe göre bir
email address sağlamak zorunda kalmış SubscribingUser; ve bir social network’teki account ID’sini düşünmeden paylaşmış
SocialUser. Bu class’ların tümü, interface’teki abstract property’yi farklı şekillerde implement eder. */

// primary constructor parameter
class PrivateUser423 (override val nickname : String) : User423

class SubscribingUser423(val email : String) : User423 {
    override val nickname: String
        get() = email.substringBefore('@') // custom getter
}

class SocialUser423(val accountId : Int) : User423{
    override val nickname = getNameFromSocialNetwork423(accountId)
}

fun getNameFromSocialNetwork423(accountId: Int) =
    "kodee$accountId"

fun main() {
    val privateUser = PrivateUser423("kodee").nickname
    println(privateUser) // kodee

    val subscribingUser = SubscribingUser423("test@kotlin.com").nickname
    println(subscribingUser) // test

    val socialUser = SocialUser423(123).nickname
    println(socialUser) // kodee123
}

/* PrivateUser için, property’yi doğrudan primary constructor’da declare etmek için kısa syntax’ı kullanırsınız. Bu
property, User’dan gelen abstract property’yi implement eder; bu nedenle override olarak işaretlersiniz. SubscribingUser
için, nickname property’si custom getter aracılığıyla implement edilir. Bu property’nin value’sunu saklamak için bir
backing field’ı yoktur; her çağrıldığında email’den nickname hesaplayan yalnızca bir getter’ı vardır. SocialUser için,
nickname property’sine value’yu initializer’ında atarsınız. getNameFromSocialNetwork function’ını kullanırsınız; bu
function, account ID verildiğinde bir social user’ın adını döndürmek üzere tasarlanmıştır. Gerçekte, bu function
maliyetli olur: istenen data’yı almak için social network provider ile bağlantı kurması gerekir. Bu nedenle, onu
yalnızca initialization aşamasında bir kez invoke etmeye karar verirsiniz. SubscribingUser ve SocialUser’daki
nickname’in farklı implementation’larına dikkat edin. Benzer görünmelerine rağmen, SubscribingUser’daki property, her
erişimde substringBefore hesaplayan bir custom getter’a sahiptir; oysa SocialUser’daki property, class initialization
sırasında hesaplanan veriyi saklayan bir backing field’a sahiptir. Abstract property declaration’larına ek olarak, bir
interface, backing field’a referans vermediği sürece getter ve setter’ları olan property’ler de içerebilir. (Bir backing
field, interface içinde state saklamayı gerektirir; bu ise izin verilmez.) İşte bir örneğe bakalım: */

interface EmailUser423 {
    val email : String
    // Property’nin bir backing field’ı yoktur: result value her erişimde hesaplanır.
    val nickname : String
        get() = email.substringBefore('@')
}

/* Bu interface, abstract property email ile custom getter’a sahip nickname property’sini içerir. İlk property
subclass’larda override edilmek zorundadır; ikinci property ise inherit edilebilir (ya da gerektiğinde override
edilebilir). */

/* Property’leri function yerine tercih etme zamanı. Parametresiz bir function veya custom getter’a sahip read-only
property declare etme zamanından kısaca bahsettik. Genel olarak, bir class’ın özellikleri property olarak declare
edilmeli ve behavior'ları method olarak declare edilmelidir. Kotlin’de, read-only property kullanmayı function yerine
tercih etmeniz için birkaç ek stil konvansiyonu vardır. İlgili code aşağıdaki niteliklerden herhangi birine sahipse,
function yerine property kullanmayı tercih edin:

* Exception fırlatmaz
* Hesaplaması ucuzdur (veya ilk çalıştırmada cache’lenmiştir)
* Object state değişmemişse, birden fazla çağrıda aynı sonucu döndürür

*/

/* Interface’lerde implement edilen property’lerin aksine, class’larda implement edilen property’ler backing field’lara
tam erişime sahiptir. Accessor’lardan onlara nasıl referans verebileceğinizi görelim. */