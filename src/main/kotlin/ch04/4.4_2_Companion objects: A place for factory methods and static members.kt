package ch04

/* Kotlin’de class’lar static member’lara sahip olamaz. Aslında Kotlin, Java’daki gibi bir static keyword’üne sahip
değildir. Bunun yerine Kotlin, package-level function’lara (birçok durumda static method’ların yerini alabilir) ve
object declaration’lara (diğer durumlarda hem static method’ların hem de static field’ların yerini alır) dayanır. Çoğu
durumda top-level function’ların kullanılması önerilir. Ancak top-level function’lar, img_07.png’de gösterildiği gibi,
bir class’ın private member’larına erişemez. Private member’lara erişmesi gereken böyle bir function’a örnek olarak
factory method verilebilir. Factory method’lar bir object’in oluşturulmasından sorumludur ve bu nedenle sıklıkla onun
private member’larına erişmeleri gerekir. Bir class instance’ına sahip olmadan call edilebilen ancak bir class’ın
internals’ına erişimi olan bir function yazmak için, onu o class’ın içinde yer alan bir object declaration’ın member’ı
olarak yazabilirsin. Bir class içinde define edilen object declaration’lardan tam olarak biri özel bir keyword ile
işaretlenebilir: companion. Bunu yaptığında, bu object’in method ve property’lerine, object’in ismini açıkça
belirtmeden, doğrudan containing class’ın name’i üzerinden erişme yeteneği kazanırsın. Ortaya çıkan syntax, Java’daki
static method invocation ile tamamen aynıdır. Aşağıda syntax’ı gösteren temel bir örnek vardır: */

class MyClass442 {
    companion object {
        fun callMe() {
            println("Companion object called")
        }
    }
}

fun main() {
    MyClass442.callMe() // Companion object called
    companionTest442()
    createUser442()
}

/* Bir companion object’in kendi class’ına ait olduğunu akılda tutmak önemlidir. Companion object’in member’larına
class’ın bir instance’ı üzerinden erişemezsin. Bu durum, onları Java’daki static member’lardan da ayırır: */

fun companionTest442(){
    val myObject = MyClass442()
    //myObject.callMe()
    // Error: Unresolved reference: callMe
}

/* Companion object, private constructor da dâhil olmak üzere class’ın tüm private member’larına erişime sahiptir.
Bu da onu factory pattern’ı implement etmek için ideal bir aday yapar. İki constructor declare etmeye dair bir örneğe
bakalım ve ardından bunu companion object içinde declare edilen factory method’ları kullanacak şekilde değiştirelim.
SocialUser ve SubscribingUser ile inşa edeceğiz. Daha önce bu entity’ler, ortak interface User’ı implement eden farklı
class’lardı. Şimdi ise yalnızca tek bir class ile yetinmeye, ancak onu oluşturmak için farklı yollar sağlamaya karar
veriyorsun. */

class User442 {
    val nickname : String

    // Secondary constructor
    constructor(email : String) {
        nickname = email.substringBefore('@')
    }

    // Secondary constructor
    constructor(socialAccountId : Int) {
        nickname = getFromSocialNetwork442(socialAccountId)
    }

    fun getFromSocialNetwork442(accountId: Int) =
        "kodee$accountId"
}

/* Aynı mantığı ifade etmenin, birçok nedenden dolayı faydalı olabilen alternatif bir yaklaşımı, class instance’larını
oluşturmak için factory method’lar kullanmaktır. User instance’ı, birden fazla constructor yerine factory method’lar
aracılığıyla oluşturulur. */

/* Primary constructor’ı private olarak işaretler; bu da onun class body’sinin dışından call edilemeyeceği anlamına
gelir. */
class User442v2 private constructor(val nickname : String) {
    companion object {
        fun newSubscribingUser(email : String) =
            User442v2(email.substringBefore('@'))
        fun newSocialUser(accountId : Int) =
            User442v2(getFromSocialNetwork442(accountId))
        fun getFromSocialNetwork442(accountId: Int) =
            "kodee$accountId"
    }
}

/* Companion object’in method’larını class name üzerinden invocation edebilirsin: */

fun createUser442() {
    val subscribingUser = User442v2.newSubscribingUser("bob@gmail.com")
    println(subscribingUser.nickname) // bob

    val socialUser = User442v2.newSocialUser(123)
    println(socialUser.nickname) // kodee123
}

/* Factory method’lar oldukça kullanışlıdır. Örnekte gösterildiği gibi, amaçlarına göre adlandırılabilirler. Ayrıca bir
factory method, method’un declare edildiği class’ın subclass’larını da döndürebilir; SubscribingUser ve SocialUser’ın
class olduğu örnekte olduğu gibi. Gereksiz olduğunda yeni object’ler oluşturmayı da engelleyebilirsin. Örneğin, her
email’in benzersiz bir User instance’ına karşılık gelmesini sağlayabilir ve factory method, cache’te zaten bulunan bir
email ile call edildiğinde yeni bir instance yerine mevcut instance’ı döndürebilir. Ancak bu tür class’ları extend etmen
gerekiyorsa, birden fazla constructor kullanmak daha iyi bir çözüm olabilir; çünkü companion object member’ları
subclass’larda override edilemez. */