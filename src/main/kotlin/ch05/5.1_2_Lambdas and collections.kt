package ch05

/* İyi programming style’ın temel prensiplerinden biri, kodunuzda duplication’dan kaçınmaktır. Collections ile
yaptığımız çoğu task, birkaç ortak pattern’i takip eder. Lambdas, Kotlin’in collections ile çalışmak için güçlü
functionality sağlayan, iyi ve kullanışlı bir standard library sunmasını mümkün kılar. Bir örneğe bakalım. Bir kişinin
name ve age bilgilerini içeren Person class’ını kullanacaksınız: */

data class Person512(val name: String, val age: Int)

/* Diyelim ki bir people list’iniz var ve en yaşlı kişiyi bulmanız gerekiyor. Lambdas konusunda deneyiminiz olmasa,
aramayı manuel olarak implement etmeye koşabilirsiniz. İki ara variable tanımlarsınız—biri maksimum age’i tutmak için,
diğeri bu age’e sahip ilk bulunan kişiyi saklamak için—ve sonra liste üzerinde iterate ederek bu variable’ları
güncellersiniz. */

fun findTheOldest512(people: List<Person512>) {
    var maxAge = 0
    var theOldest: Person512? = null
    for (person in people) {
        if (person.age > maxAge) {
            maxAge = person.age
            theOldest = person
        }
    }
    println(theOldest)
}

fun main() {
    val people = listOf(
        Person512("Alice", 29),
        Person512("Bob", 31),
        Person512("Ocean", 16)
    )
    findTheOldest512(people) // Person512(name=Bob, age=31)
    println(findTheOldest512v2(people)) // Person512(name=Bob, age=31)
    println(findTheOldest512v3(people)) // Person512(name=Bob, age=31)
}

/* Yeterli deneyime sahip olduğunuzda, böyle loop’ları oldukça hızlı yazabilirsiniz. Ancak burada oldukça fazla kod var
ve hata yapmak kolaydır. Örneğin, comparison’ı yanlış yapabilir ve maksimum yerine minimum element’i bulabilirsiniz.
Kotlin’de daha iyi bir yol vardır. Bunu, aşağıda gösterildiği gibi standard library’den bir function kullanarak
yapabilirsiniz. */

fun findTheOldest512v2(people: List<Person512>): Person512? {
    // Yaşları karşılaştırarak maksimumu bulur
    return people.maxByOrNull { it.age }
}

/* maxByOrNull function’ı herhangi bir collection üzerinde çağrılabilir ve bir argument alır: maksimum element’i bulmak
için hangi değerlerin karşılaştırılacağını belirten function. Küme parantezleri içindeki kod { it.age } bu selector
logic’i implement eden bir lambda’dır; bir collection element’ini argument olarak alır ve karşılaştırılacak bir değer
return eder. Lambda yalnızca bir argument (collection item) alır ve ona explicit bir isim vermediğimiz için, implicit
isim **it** ile referans veririz. Bu örnekte, collection element bir Person object’idir ve karşılaştırılacak değer, age
property’sinde saklanan age’idir. Eğer bir lambda sadece bir function veya property’ye delegate ediyorsa, bu bir member
reference ile değiştirilebilir. */

fun findTheOldest512v3(people: List<Person512>): Person512? {
    return people.maxByOrNull(Person512::age)
}

/* Bu code, v2 ile aynı anlama gelir. Collections ile tipik olarak yaptığımız çoğu şey, lambdas veya member references
alan library functions ile kısa ve öz bir şekilde ifade edilebilir. Ortaya çıkan code çok daha kısa ve anlaşılması
kolaydır ve çoğu zaman loop tabanlı karşılığına göre niyetinizi (yani code’unuzun neyi başarmaya çalıştığını) daha net
iletir. Buna alışmanıza yardımcı olmak için, şimdi lambda expressions için syntax’a bakalım. Daha sonra, chapter 6’da,
lambdas kullanarak collections’ları manipüle etmek için hangi functionality’nin mevcut olduğuna daha ayrıntılı bir
şekilde bakacağız. */