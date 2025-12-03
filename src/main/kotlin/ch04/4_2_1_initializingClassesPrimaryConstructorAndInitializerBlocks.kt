package ch04

/* Genellikle bir class içindeki tüm declaration’lar süslü parantezlerin içine yazılır, bu yüzden bu class’ın neden
farklı olduğunu merak edebilirsiniz. Süslü parantezleri yoktur ve bunun yerine yalnızca parantez içinde bir declaration
vardır. Parantezlerle çevrili bu kod bloğu primary constructor olarak adlandırılır. İki amaca hizmet eder: constructor
parameter’larını belirtmek ve bu parameter’larla initialize edilen property’leri tanımlamak. Burada neler olduğunu
açalım ve aynı şeyi yapan en açık kodun nasıl göründüğüne bakalım:
*/

class User constructor(_nickname: String) { // primary constructor (1 parametreli)
    val nickname: String

    // Initializer block
    init {
        nickname = _nickname
    }
}

/* Bu örnekte iki yeni Kotlin keyword’ü görüyorsunuz: constructor ve init. Constructor keyword’ü bir primary veya
secondary constructor’ın declaration’ını başlatır ve init keyword’ü bir initializer block’u tanıtır. Bu block’lar, class
oluşturulduğunda çalışan initialization code içerir ve primary constructor’larla birlikte kullanılmak üzere
tasarlanmıştır. Primary constructor’ın syntax’ı kısıtlı olduğundan initialization code içeremez; bu yüzden initializer
block’ları vardır. İsterseniz bir class içinde birden fazla initializer block declare edebilirsiniz. Constructor
parameter’ındaki _nickname alt çizgisi, property’nin adıyla constructor parameter’ının adını birbirinden ayırmaya yarar.
Alternatif bir olasılık olarak aynı adı kullanabilir ve belirsizliği gidermek için this yazabilirsiniz:
this.nickname = nickname. Bu örnekte initialization code’u initializer block içine koymanız gerekmez, çünkü nickname
property’sinin declaration’ı ile birleştirilebilir. Primary constructor üzerinde annotation veya visibility modifier
yoksa constructor keyword’ünü de atlayabilirsiniz. Bu değişiklikleri uygularsanız aşağıdakini elde edersiniz:
*/


class UserV2(_nickname: String) { // Primary constructor (1 parametreli)
    val nickname = _nickname // Property, parameter ile initialize edilir.
}

/* Bu, aynı class’ı declare etmenin başka bir yoludur. Primary constructor parameter’larına property initializer’larında
ve initializer block’larda nasıl başvurabileceğinize dikkat edin. Önceki iki örnek, property’yi class body’si içinde val
keyword’ü kullanarak declare etti. Eğer property, ilgili constructor parameter’ı ile initialize ediliyorsa, kod val
keyword’ünü parameter’ın önüne ekleyerek basitleştirilebilir. Bu, class body’sindeki property tanımının yerini alır:
*/

// Val, ilgili property’nin constructor parameter için generate edildiği anlamına gelir.
class UserV3(val nickname: String)

/* User class’ının tüm bu declaration’ları aynı şeyi gerçekleştirir, ancak sonuncusu en özlü syntax’ı kullanır.
Constructor parameter’ları için default value’lar declare edebilirsiniz; tıpkı function parameter’ları için
yapabildiğiniz gibi.
*/

class UserV4(
    val nickname: String,
    val isSubscribed: Boolean = true
)

/* Bir class instance'ını oluşturmak için constructor’ı doğrudan çağırırsınız, new gibi ekstra keyword’ler kullanmadan.
Varsayılan olarak mailing list’e abone olan potansiyel kullanıcılarımız Alice’i, terms and conditions’ı dikkatlice
okuyup default seçeneği kaldıran Bob ve Carol’u ve marketing departmanımızın paylaşacaklarına açıkça ilgi duyan Dave’i
gösterecek şekilde bunu örnekleyelim:
*/

fun main() {
    val alice = UserV4("Alice")
    println(alice.isSubscribed) // true
    val bob = UserV4("Bob", false)
    val dave = UserV4(nickname = "Dave", isSubscribed = true)
}

/* Eğer tüm constructor parameter’larının default value’ları varsa, compiler tüm default value’ları kullanan
parametresiz ek bir constructor generate eder. Bu, Kotlin’i parametresiz constructor’lar aracılığıyla class instantiate
eden kütüphanelerle kullanmayı kolaylaştırır. Java kodunuzun bazı default parameter’ları olan bir Kotlin constructor’ını
çağırması gerekiyorsa, constructor’ı @JvmOverloads constructor olarak belirtebilirsiniz. Bu, compiler’a Java’dan
kullanım için uygun overload’ları generate etmesini söyler;*/

/* Eğer bir superclass’in constructor’ı argüman alıyorsa, sizin class’ınızın primary constructor’ı da onları initialize
etmelidir. Bunu, superclass referansından sonra base class list içinde superclass constructor parameter’larını
sağlayarak yapabilirsiniz:
*/

open class UserV5(val nickname : String)

class SocialUser(nickname : String) : UserV5(nickname)

/* Eğer bir class için herhangi bir constructor declare etmezseniz, sizin için hiçbir şey yapmayan parametresiz bir
default constructor generate edilir:
*/

// open class Button

/* Button class’ından inherit ederseniz ve herhangi bir constructor sağlamazsanız, superclass’in constructor’ını açıkça
çağırmanız gerekir, parametresi olmasa bile. Bu yüzden superclass’in adından sonra boş parantez kullanmanız gerekir:
*/

// class RadioButton : Button()

/* Interface’lerle farkına dikkat edin: interface’lerin constructor’ı yoktur, bu yüzden bir interface’i implement
ederseniz, supertype list içinde adından sonra hiçbir zaman parantez koymazsınız. Eğer class’ınızın kendisi dışındaki
kod tarafından instantiate edilmesini engellemek istiyorsanız, constructor’ı private yapmanız gerekir. Primary
constructor’ı private yapma şekli şöyledir:
*/

// class Secret private constructor(private val agentName: String) {}

/* Secret class’ın yalnızca private constructor’a sahip olması nedeniyle, class dışındaki kod onu instantiate edemez.*/