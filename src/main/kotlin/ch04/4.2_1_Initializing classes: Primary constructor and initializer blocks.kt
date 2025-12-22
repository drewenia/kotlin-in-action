package ch04

/* Daha önce, basit bir class’ın nasıl declare edileceğini görmüştünüz: */

class User421(val nickname: String)

/* Genellikle bir class’taki tüm declaration’lar süslü parantezlerin içinde yer alır; bu nedenle bu class’ın neden
farklı olduğunu merak edebilirsiniz. Süslü parantezleri yoktur ve bunun yerine yalnızca parantezler içinde bir
declaration vardır. Parantezlerle çevrili bu code bloğu primary constructor olarak adlandırılır. İki amaca hizmet eder:
constructor parameter’larını belirtmek ve bu parameter’lar tarafından initialize edilen property’leri tanımlamak. Burada
neler olduğunu açalım ve aynı şeyi yapan, yazabileceğiniz en açık code’a bakalım: */

class User421v2 constructor(_nickname: String) {
    val nickname : String

    // Initializer block
    init {
        nickname = _nickname
    }
}

/* Bu örnekte iki yeni Kotlin keyword’ü görüyorsunuz: constructor ve init. constructor keyword’ü, bir primary ya da
secondary constructor declaration’ını başlatır; init keyword’ü ise bir initializer block’u tanıtır. Bu block’lar, class
oluşturulduğunda çalıştırılan initialization code’unu içerir ve primary constructor’larla birlikte kullanılmak üzere
tasarlanmıştır. Primary constructor’ın syntax’ı sınırlı olduğu için initialization code’u içeremez; bu yüzden
initializer block’ları vardır. İsterseniz bir class içinde birden fazla initializer block declare edebilirsiniz.
constructor parameter’ındaki underscore (_nickname), property’nin adını constructor parameter’ının adından ayırt etmek
için kullanılır. Alternatif bir olasılık, aynı adı kullanmak ve belirsizliği ortadan kaldırmak için this yazmaktır:
this.nickname = nickname. Bu örnekte, initialization code’unu initializer block içine koymanız gerekmez; çünkü nickname
property’sinin declaration’ı ile birleştirilebilir. Ayrıca, primary constructor üzerinde annotation veya visibility
modifier yoksa constructor keyword’ünü de atlayabilirsiniz. Bu değişiklikleri uygularsanız, aşağıdakini elde edersiniz:
*/

// Tek parameter’lı primary constructor
class User421v3(_nickname: String) {
    // Property, parameter ile initialize edilir.
    val nickname = _nickname
}

/* Bu, aynı class’ı declare etmenin başka bir yoludur. Primary constructor parameter’larına, property
initializer’larında ve initializer block’larda nasıl referans verebildiğinize dikkat edin. Önceki iki örnek, property’yi
class body’sinde val keyword’ünü kullanarak declare ediyordu. Eğer property, karşılık gelen constructor parameter’ı ile
initialize ediliyorsa, parameter’ın önüne val keyword’ünü ekleyerek code sadeleştirilebilir. Bu, class body’sindeki
property tanımının yerini alır: */

// val, constructor parameter’ı için karşılık gelen bir property’nin generate edildiği anlamına gelir.
class User421v4(val nickname : String)

/* User class’ının tüm bu declaration’ları aynı sonucu sağlar, ancak sonuncusu en kısa ve öz syntax’ı kullanır.
Constructor parameter’ları için de tıpkı function parameter’larında olduğu gibi default value’lar declare edebilirsiniz:
*/

class User421v5(
    val nickname : String,
    // Constructor parameter’ı için default value sağlar
    val isSubscribed : Boolean = true
)

/* Bir class’ın instance’ını oluşturmak için, new gibi ek keyword’ler olmadan constructor’ı doğrudan call edersiniz.
Olası kullanıcılarımızdan Alice’in varsayılan olarak mailing list’e subscribe olduğunu, Bob ve Carol’ın terms and
conditions’ı dikkatlice okuyup default seçeneği devre dışı bıraktığını ve Dave’in marketing department’ımızın
paylaşacaklarıyla özellikle ilgilendiğini nasıl gösterebileceğimize bakalım: */

fun main() {
    val alice = User421v5("Alice")
    println(alice.isSubscribed) // true

    val bob = User421v5("Bob",false)
    println(bob.isSubscribed) // false

    // Bazı constructor argument’ları için adları explicitly belirtebilirsiniz. (isSubscribed)
    val carol = User421v5("Carol", isSubscribed = false)
    println(carol.isSubscribed) // false

    // Tüm constructor argument’ları için adları belirtebilirsiniz.
    val dave = User421v5(nickname = "Dave", isSubscribed = true)
    println(dave.isSubscribed) // true
}

/* NOT: Eğer tüm constructor parameter’larının default value’su varsa, Compiler tüm default value’ları kullanan,
parameter’sız ek bir constructor generate eder. Bu, class’ları parameter’sız constructor’lar aracılığıyla instantiate
eden library’lerle Kotlin’i kullanmayı kolaylaştırır. Java code’unun bazı default parameter’lara sahip bir Kotlin
constructor’ını call etmesi gerekiyorsa, constructor’ı @JvmOverloads constructor olarak belirtebilirsiniz. Bu,
Compiler’a Java’dan kullanım için uygun overload’ları generate etmesini söyler; */

/* Eğer bir superclass’ın constructor’ı argument alıyorsa, sizin class’ınızın primary constructor’ı da onları initialize
etmek zorundadır. Bunu, base class list’inde superclass referansından sonra superclass constructor parameter’larını
sağlayarak yapabilirsiniz: */

open class User421v6 (val nickname : String)

class SocialUser(nickname : String) : User421v6(nickname)

/* Bir class için herhangi bir constructor declare etmezseniz, parameter’sız ve hiçbir şey yapmayan bir default
constructor sizin için generate edilir. */

// Argument’sız bir default constructor generate edilir.
open class Button421

/* Button class’ından inherit ederseniz ve herhangi bir constructor sağlamazsanız, superclass’ın constructor’ını
parameter almasa bile açıkça invoke etmeniz gerekir. Bu yüzden superclass adından sonra boş parantezlere ihtiyaç
duyarsınız: */

class RadioButton : Button421()

/* Interface’lerle olan farka dikkat edin: interface’lerin constructor’ı yoktur; bu nedenle bir interface’i implement
ettiğinizde, supertype list’inde adından sonra asla parantez koymazsınız. Bir class’ın, class’ın kendisi dışındaki code
tarafından instantiate edilememesini istiyorsanız, constructor’ı private yapmanız gerekir. Primary constructor’ı private
yapmanın yolu şöyledir: */

class Secret421 private constructor(private val agentName : String)

/* Secret class’ının yalnızca private bir constructor’ı olduğu için, class dışındaki code onu instantiate edemez. Daha
sonra, bu tür constructor’ları call etmek için iyi bir yer olabilecek companion object’lerden bahsedeceğiz. Private
constructor’lara alternatifler Java’da, class’ın instantiate edilmesini yasaklayan private bir constructor kullanarak
daha genel bir fikri ifade edebilirsiniz: class, static utility member’ların bir container’ıdır ya da bir singleton’dır.
Kotlin, bu amaçlar için built-in dil özelliklerine sahiptir. Static utility’ler olarak top-level function’ları
kullanırsınız. Singleton’ları ifade etmek için ise, daha sonra göreceğiniz üzere object declaration’ları kullanırsınız.
Gerçek use case'lerin çoğunda, bir class’ın constructor’ı basittir: ya hiç parameter içermez ya da parameter’ları
karşılık gelen property’lere assign eder. Bu yüzden Kotlin, primary constructor’lar için kısa ve öz bir syntax’a
sahiptir; çoğu durumda mükemmel şekilde çalışır. Ancak hayat her zaman bu kadar kolay değildir, bu nedenle Kotlin bir
class’ın ihtiyaç duyduğu kadar constructor tanımlamanıza izin verir. Bunun nasıl çalıştığına bakalım. */