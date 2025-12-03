package ch04

/* Değerleri saklayan property’ler ve her access’te değer hesaplayan custom accessor’lara sahip property’ler olmak üzere
iki tür property’ye birkaç örnek gördünüz. Şimdi, ikisini birleştirip bir value saklayan ve değer access edildiğinde
veya değiştirildiğinde ek logic çalıştıran bir property nasıl implement edilir göreceğiz. Bunun için, accessor’lardan
property’nin backing field’ına erişebilmeniz gerekir.
*/

class UserBackingField(val name: String) {
    var address: String = "unspecified"
        set(value: String) {
            println(
                """
                   Address was changed for $name:
                   "$field" -> "$value"
               """.trimIndent()
            )
            field = value // Sağlanan string ile backing field değerini günceller.
        }
}

fun main() {
    val user = UserBackingField("Alice")
    user.address = "Christoph-Rapparini-Bogen 23"
    println(user)
    /*
        Address was changed for Alice:
        "unspecified" -> "Christoph-Rapparini-Bogen 23"
    */
}

/* Bir property değerini her zamanki gibi user.address = "new value" diyerek değiştirirsiniz; bu, altında setter’ı
invoke eder. Bu örnekte, setter yeniden tanımlanmıştır, bu nedenle ek logging code çalıştırılır (basitlik açısından bu
durumda ekrana yazdırılır). Setter gövdesinde, backing field değerine erişmek için özel identifier field kullanırsınız.
Getter içinde yalnızca değeri okuyabilirsiniz, setter içinde ise hem okuyabilir hem de değiştirebilirsiniz. Dikkat edin,
eğer mutable bir property için getter veya setter trivial ise, yalnızca custom behavior gerektiği accessor’ı define
etmeyi seçebilirsiniz, diğerini yeniden tanımlamanıza gerek yoktur.
*/

/* Bir property’nin backing field’a sahip olması ile olmaması arasındaki farkın ne olduğunu merak edebilirsiniz.
Property’ye erişme şekliniz, backing field’a sahip olup olmadığına bağlı değildir; eğer backing field’a açıkça referans
verirseniz veya default accessor implementation’ı kullanırsanız, compiler property için backing field oluşturur. Eğer
custom accessor implementation’ları sağlarsanız ve field kullanmazsanız (property val ise getter için, mutable property
ise her iki accessor için), compiler property’nin kendi başına herhangi bir bilgi saklamasına gerek olmadığını anlar ve
backing field oluşturulmaz. Aşağıdaki listing, Person’ın birthYear’una bağlı olarak tamamen tanımlanan ageIn2050
property’si ile bunu gösterir.
*/

class PersonBirthday (var birthYear : Int){
    var ageIn2050
        // Getter içinde field referansı yok
        get() = 2050 - birthYear
        set(value){
            birthYear = 2050 - value // veya setter, backing field oluşturulmayacağı anlamına gelir.
        }
}

/* Bazen bir accessor’ın default implementation’ını değiştirmeye gerek yoktur, fakat visibility’sini yine de değiştirmek
gerekir.
*/