package ch04

/* Değer saklayan property’ler ile her erişimde değer hesaplayan custom accessor’lı property’lerden birkaç örnek
gördünüz. Şimdi, ikisini birleştirip hem değer saklayan hem de değere erişildiğinde veya değiştirildiğinde ek logic
çalıştıran bir property’yi nasıl implement edebileceğinizi görelim. Bunun için, accessor’lardan property’nin backing
field’ına erişebilmeniz gerekir. */

class User424(val name: String) {
    var address: String = "unspecified"
        set(value) {
            println(
                """
                    Address was changed for $name :
                    "$field" -> "$value".
                """.trimIndent()
            )
            // Backing field değerini sağlanan string ile günceller
            field = value
        }
}

fun main() {
    val user = User424("Alice")
    user.address = "Christoph-Rapparini-Bogen 23"
    user.address = "265/2 Street"
    // Address was changed for Alice
    // "unspecified" -> "Christoph-Rapparini-Bogen 23".
    // Address was changed for Alice :
    // "Christoph-Rapparini-Bogen 23" -> "265/2 Street".

    val person = Person424(1976)
    println("Age in 2050 : ${person.ageIn2050}") // Age in 2050 : 74

    /* ageIn2050 property'sine değer ata (setter çalışır, birthYear güncellenir) */
    person.ageIn2050 = 60
    println("New birthyear : ${person.birthYear}") // New birthyear : 1990
}

/* Property değerini her zamanki gibi user.address = "new value" diyerek değiştirirsiniz; bu, arka planda setter’ı
invoke eder. Bu örnekte setter yeniden tanımlandığı için ek logging code çalıştırılır (basitlik adına burada print
edilir). Setter gövdesinde, backing field değerine erişmek için özel identifier field kullanılır. Getter içinde yalnızca
değeri okuyabilirsiniz; setter içinde ise hem okuyabilir hem de değiştirebilirsiniz. Mutable bir property için getter
veya setter trivial ise, yalnızca custom behavior’a ihtiyaç duyduğunuz accessor’ı tanımlamayı seçebilirsiniz; diğerini
yeniden tanımlamanıza gerek yoktur. Örneğin, yukarıda ki getter trivialdır ve yalnızca field değerini döndürür, bu
yüzden onu yeniden tanımlamanıza gerek yoktur. Backing field’a sahip bir property ile olmayan bir property arasındaki
farkın ne olduğunu merak edebilirsiniz. Property’ye erişim şekliniz, backing field’a sahip olup olmadığına bağlı
değildir; eğer field’ı açıkça referans verirseniz veya varsayılan accessor implementation’ını kullanırsanız, Compiler
property için backing field üretir. Eğer custom accessor implementation’ları sağlarsanız ve bunlar field kullanmazsa
(val bir property için getter’da, mutable bir property için her iki accessor’da), Compiler property’nin kendi içinde
herhangi bir bilgi saklamasına gerek olmadığını anlar ve backing field üretilmez. Aşağıdaki kod, ageIn2050 property’si
ile bunu gösterir; bu property, tamamen bir Person’ın birthYear’ına bağlı olarak tanımlanmıştır. */

class Person424(var birthYear: Int) {
    var ageIn2050
        // Getter içinde field referansı yok
        get() = 2050 - birthYear
        // Setter’da da field referansı yoksa, backing field üretilmez.
        set(value) {
            birthYear = 2050 - value
        }
}

/* Bazen bir accessor’ın varsayılan implementation’ını değiştirmeye gerek yoktur, ancak visibility’sini değiştirmek
gerekebilir. Bunu nasıl yapabileceğinize bakalım. */