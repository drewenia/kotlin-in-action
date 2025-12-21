package ch04

/* Tüm Kotlin class’larının, Java’dakine benzer şekilde override etmek isteyebileceğiniz birkaç method’u vardır:
toString, equals ve hashCode. Bu method’ların neler olduğunu ve Kotlin’in bunların implementation’larını otomatik
olarak nasıl generate edebileceğini inceleyelim. Başlangıç olarak, bir customer’ın name ve postal code’unu tutan basit
bir Customer class’ını kullanacaksınız. */

class Customer431(val name: String, val postalCode: Int)

/* Class instance’larının string olarak nasıl represent edildiğine bakalım. STRING REPRESENTATION: TOSTRING() Tüm
Kotlin class’ları, Java’daki gibi, class’ın object’lerinin string representation'ınını alma imkânı sağlar. Bu, öncelikle
debugging ve logging için kullanılır, ancak bu işlevi başka context’lerde de kullanabilirsiniz. Varsayılan olarak, bir
object’in string temsili Customer@5e9f23b4 gibi görünür (class adı ve object’in saklandığı bellek adresi); pratikte bu
pek kullanışlı değildir. Bunu değiştirmek için toString method’unu override etmeniz gerekir. */

class Customer431v2(val name: String, val postalCode: Int) {
    override fun toString() = "Customer(name = $name, postalCode = $postalCode)"
}

fun main() {
    val customer1 = Customer431v2("Alice", 34256)
    println(customer1) // Customer(name = Alice, postalCode = 34256)

    val customer2 = Customer431v2("Derek", 74300)
    val customer3 = Customer431v2("Derek", 74300)
    /* Kotlin’de ==, object’lerin eşit olup olmadığını kontrol eder, referanslarını değil. Bu, equals çağrısına compile
    edilir. */
    println(customer2 == customer3) // false

    val customer4 = Customer431v3("John", 21400)
    val customer5 = Customer431v3("John", 21400)
    println(customer4 == customer5) // true

    val processed = hashSetOf(Customer431v3("Alice", 35100))
    println(processed.contains(Customer431v3("Alice", 35100))) // false

    val processed2 = hashSetOf(Customer431v4("Mia",35400))
    println(processed2.contains(Customer431v4("Mia",35400))) // true
}

/* OBJECT EQUALITY: EQUALS() - Customer class’ı ile yapılan tüm hesaplamalar class’ın dışında gerçekleşir. Bu class
sadece veriyi saklar; basit ve şeffaf olması amaçlanmıştır. Yine de, böyle bir class’ın davranışıyla ilgili bazı
gereksinimleriniz olabilir. Örneğin, eğer object’ler aynı veriyi içeriyorsa eşit kabul edilmelerini isteyebilirsiniz:
main methodunda örneklendirildi. Görüyorsunuz ki object’ler eşit değil. Bunu düzeltmek için, Customer class’ı için
equals method’unu override etmeniz gerekir. */

/*

== for equality

Java’da == operator’ü primitive ve reference type’ları karşılaştırmak için kullanılabilir. Primitive type’lara
uygulandığında, Java’nın == değeri karşılaştırır; reference type’larda ise referansları karşılaştırır. Bu nedenle,
Java’da her zaman equals çağırmak yaygın bir uygulamadır ve bunu unutmak da bilinen bir problemdir. Kotlin’de ==
operator’ü iki object’i karşılaştırmanın varsayılan yoludur: arka planda equals çağırarak değerlerini karşılaştırır.
Dolayısıyla, class’ınızda equals override edilmişse, instance’larını == ile güvenle karşılaştırabilirsiniz. Referans
karşılaştırması için === operator’ünü kullanabilirsiniz; bu, Java’daki == ile tamamen aynı şekilde çalışır ve object
referanslarını karşılaştırır. Başka bir deyişle, === iki referansın bellekte aynı object’i işaret edip etmediğini
kontrol eder. == ve ===’nin negated karşılıkları olan != ve !== de buna göre davranır.

*/

/* Değiştirilen Customer class’ına bakalım. Kotlin’de equals function’ı, type’ı Any olan nullable bir parameter other
alır — Any, Kotlin’deki tüm class’ların superclass’ıdır ve bunu daha yakından tanıyacaksınız. main methodunda
örnekledim */

class Customer431v3(val name: String, val postalCode: Int) {
    /* Any, java.lang.Object’in karşılığıdır: Kotlin’deki tüm class’ların superclass’ıdır. Nullable type Any?, other’ın
    null olabileceği anlamına gelir. */
    override fun equals(other: Any?): Boolean {
        // other’ın bir Customer olup olmadığını kontrol eder
        if (other == null || other !is Customer431v3)
            return false
        // İlgili property’lerin eşit olup olmadığını kontrol eder
        return name == other.name && postalCode == other.postalCode
    }

    override fun toString() = "Customer(name = $name, postalCode = $postalCode)"
}

/* Hatırlatmak gerekirse, is operator’ü bir value’nun belirtilen type’a sahip olup olmadığını kontrol eder ve other’ı
Customer type’ına smart cast eder (Java’daki instanceof’ın karşılığıdır). in kontrolünün negasyonu olan !in operator’ü
gibi !is operator’ü de is kontrolünün negasyonunu ifade eder. Bu tür operator’ler kodunuzu okunabilir hâle getirir.
Daha sonra nullable type’ları ve other == null || other !is Customer koşulunun neden other !is Customer olarak
basitleştirilebileceğini detaylı şekilde tartışacağız. Kotlin’de override modifier zorunlu olduğu için, yanlışlıkla
fun equals(other: Customer) yazmak ve equals’ı override etmek yerine yeni bir method eklemekten korunursunuz. Equals’ı
override ettikten sonra, aynı property değerlerine sahip customer’ların eşit olduğunu bekleyebilirsiniz. Gerçekten de,
önceki örnekte customer4 == customer5 artık true döner. Ancak, customer’lar üzerinde daha karmaşık işlemler yapmak
istiyorsanız, bu işe yaramaz. Yaygın bir interview sorusu şudur: “Ne kırık ve sorun ne?” Sorun, hashCode’un eksik
olmasıdır. Gerçekten de durum böyledir ve bunun neden önemli olduğunu şimdi tartışacağız. */

/*

HASH CONTAINERS: HASHCODE()

hashCode method’u, equals ile birlikte her zaman override edilmelidir. Bu bölüm bunun nedenini açıklar. Bir elemanı olan
bir set oluşturun: adı Alice olan bir customer. Ardından, aynı veriyi içeren yeni bir Customer instance’ı oluşturun ve
bunun set içinde olup olmadığını kontrol edin. İki instance eşit olduğu için kontrolün true dönmesini beklersiniz; ancak
gerçekte false döner: main methodunda örnekledim. Bunun nedeni, Customer class’ında hashCode method’unun eksik
olmasıdır. Bu nedenle genel hashCode sözleşmesi ihlal edilir: iki object eşitse, aynı hash code’a sahip olmalıdırlar.
İşlenen set bir HashSet’tir. HashSet’teki değerler optimize edilmiş bir şekilde karşılaştırılır: önce hash code’ları
karşılaştırılır, ardından yalnızca hash code’ları eşitse gerçek değerler karşılaştırılır. Önceki örnekte Customer
class’ının iki farklı instance’ı için hash code’lar farklıdır, bu yüzden set ikinci object’i içermediğine karar verir;
oysa equals true döndürürdü. Bu nedenle, bu kurala uyulmazsa, HashSet gibi data structure’lar bu tür object’lerle doğru
çalışamaz. Bunu düzeltmek için, class’a uygun bir hashCode implementation’ı sağlamalısınız. */

class Customer431v4(val name: String, val postalCode: Int) {
    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Customer431v4)
            return false
        return name == other.name && postalCode == other.postalCode
    }

    /* Kotlin’de (ve Java’da) hashCode() implementasyonu yaparken sabit bir asal sayı ile çarpma yaygın bir pratiktir.
    Senin örneğinde Neden 31 kullanılıyor? : hashCode() bir Int döndürür. Eğer sadece property’leri toplarsak
    (name.hashCode() + postalCode) çakışmalar daha fazla olur. Sabit bir sayı ile çarparak farklı değerlerin hash
    değerleri daha iyi dağılır. 31 asal bir sayı → çarpma sonrası kombinasyonlar daha az çakışır. Java’nın
    String.hashCode() implementasyonu da 31 kullanır */
    override fun hashCode() : Int = name.hashCode() * 31 + postalCode

    override fun toString() = "Customer(name = $name, postalCode = $postalCode)"
}

/* main methodunda yukarıda ki kodu örnekledim. Artık tüm senaryolarda beklediğiniz gibi çalışan bir class’ınız var —
ama yazmanız gereken code miktarına dikkat edin. Neyse ki, Kotlin compiler tüm bu method’ları otomatik olarak generate
ederek size yardımcı olabilir. Bunu nasıl yapabileceğinize bakalım. */