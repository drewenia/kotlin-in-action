package ch04

import java.io.File

/* Object-oriented sistemlerin tasarımında oldukça yaygın bir durum, yalnızca tek bir instance’ına ihtiyaç duyulan bir
class’ın bulunmasıdır. Bu genellikle Java gibi language’lerde singleton pattern kullanılarak implement edilir: private
bir constructor’a sahip bir class define edilir ve class’ın var olan tek instance’ını tutan static bir field bulunur.
Kotlin, object declaration feature’ını kullanarak bunun için first-class language support sağlar. Object declaration,
bir class declaration’ını ve bu class’ın tek bir instance’ının declaration’ını birleştirir. Örneğin, bir organization’ın
payroll’unu (maaş bordrosu) represent etmek için object declaration kullanabilirsin. Muhtemelen birden fazla payroll’a
sahip değilsindir, bu nedenle—uygulamanın genel karmaşıklığına bağlı olarak—bunun için bir object kullanmak mantıklı
olabilir: */

data class Person441(val name: String)

object Payroll441 {
    val allEmployees = mutableListOf<Person441>()
    fun calculateSalary() {
        for (person in allEmployees) {
            println("Calculated salary : Name : ${person.name}")
        }
    }
}

/* Object declaration’lar object keyword’ü ile tanıtılır. Bir object declaration, etkili bir şekilde bir class ve aynı
isimde bir variable’ı tek bir statement içinde define eder. Tıpkı bir class gibi, bir object declaration property,
method, initializer block ve benzeri declaration’lar içerebilir. Tek izin verilmeyen şeyler constructor’lardır
(primary veya secondary). Normal class’ların instance’larının aksine, object declaration’lar tanımlandıkları noktada
hemen oluşturulur, kodun diğer yerlerinden constructor call edilerek değil. Bu nedenle, bir object declaration için
constructor define etmek mantıklı değildir. Benzer şekilde, object declaration’a vermek istediğin initial state,
o object’in body’sinin bir parçası olarak sağlanmalıdır. Ve tıpkı bir variable gibi, bir object declaration method call
etmene ve property’lerine erişmene olanak tanır; . karakterinin solunda object ismini kullanarak: */

fun main() {
    Payroll441.allEmployees.add(Person441("Alice"))
    Payroll441.calculateSalary()

    val compare = CaseInsensitiveFileComparator441.compare(File("/User"), File("/user"))
    println(compare) // 0

    val files = listOf(File("/Z"), File("/a"))
    // Burada, belirtilen Comparator’a göre sıralanmış bir liste döndüren sortedWith function’ını kullanıyorsun.
    val sorted = files.sortedWith(CaseInsensitiveFileComparator441)
    println(sorted) // [/a, /Z]

    val persons = listOf(
        Person441v2("Bob"),
        Person441v2("Alex"),
        Person441v2("Derek"),
        Person441v2("Ocean"),
        Person441v2("Alice"),
    )
    val sortedList = persons.sortedWith(Person441v2.NameComparator)
    println(sortedList)
    // [Person441v2(name=Alex), Person441v2(name=Alice), Person441v2(name=Bob), Person441v2(name=Derek),
    // Person441v2(name=Ocean)]
}

/* Object declaration’lar aynı zamanda class ve interface’lerden inherit edebilir. Bu, genellikle kullandığın
framework’ün bir interface implement etmeni gerektirdiği ancak implementation’ının herhangi bir state içermediği
durumlarda faydalıdır. Örneğin, Comparator interface’ini ele alalım. Bir Comparator implementation’ı iki object alır ve
hangi object’in daha büyük olduğunu gösteren bir integer döner. Comparator’lar neredeyse hiç veri saklamaz, bu nedenle
object’leri karşılaştırmanın belirli bir yolu için genellikle yalnızca tek bir Comparator instance’ına ihtiyaç duyarsın.
Bu, object declaration için mükemmel bir kullanım durumudur. Bir örnek olarak, dosya path’lerini case insensitive
olarak karşılaştıran bir comparator implement edelim. Comparator'un örneğini main function'da oluşturdum */

object CaseInsensitiveFileComparator441 : Comparator<File> {
    override fun compare(file1: File, file2: File): Int {
        /* compareTo(..., ignoreCase = true) → String karşılaştırması yapıyor, büyük/küçük harf farkını görmezden
        geliyor. */
        return file1.path.compareTo(file2.path, ignoreCase = true)
    }
}

/*

Dönüş değeri:

< 0 → file1 < file2
0 → file1 = file2
> 0 → file1 > file2

*/

/* Singleton object’ları, normal bir object’in (bir class instance’ının) kullanılabileceği her context’te
kullanabilirsin. Örneğin, bu object’i Comparator alan bir function’a argument olarak geçirebilirsin: main function'da
gösterildi. sortedWith bir comparator alır */

/* Tıpkı singleton pattern’da olduğu gibi, object declaration’lar büyük yazılım sistemlerinde her zaman ideal değildir.
Az veya hiç dependency içermeyen küçük kod parçaları için mükemmeldirler, ancak sistemin birçok diğer kısmıyla etkileşen
büyük komponentler için uygun değildirler. Bunun başlıca nedeni, object’lerin instantiation’ı üzerinde hiçbir kontrolün
olmaması ve constructor’lar için parameter belirleyememendir. Bu, unit test’lerde veya yazılım sisteminin farklı
konfigürasyonlarında object’in kendi implementation’larını veya object’in bağımlı olduğu diğer class’ları
değiştiremeyeceğin anlamına gelir. Bunu yapman gerekiyorsa, normal Kotlin class’ları ve dependency injection
kullanmalısın. */

/* Ayrıca class içinde de object declare edebilirsin. Bu tür object’lerin de yalnızca tek bir instance’ı vardır;
containing class’ın her instance’ı için ayrı bir instance oluşturulmaz. Örneğin, belirli bir class’ın object’lerini
karşılaştıran bir comparator’ı o class’ın içinde bulundurmak mantıklıdır. */

data class Person441v2(val name: String) {
    object NameComparator : Comparator<Person441v2> {
        override fun compare(p1 : Person441v2, p2 : Person441v2) : Int =
            p1.name.compareTo(p2.name)
    }
}

/* Person441v2 main function içerisinde örneklendirildi. */

/*
Kotlin’de bir object declaration, tek instance’ını tutan static bir field
ile bir class olarak compile edilir ve bu field her zaman INSTANCE olarak adlandırılır. Eğer Java’da singleton pattern
implement ettiysen, muhtemelen aynı şeyi manuel olarak yapardın. Bu nedenle, bir Kotlin object’ini Java code’undan
kullanmak için static INSTANCE field’a erişirsin: */

/*
/* Java */
CaseInsensitiveFileComparator.INSTANCE.compare(file1, file2);
Person.NameComparator.INSTANCE.compare(person1, person2)
*/

/* Şimdi, bir class içinde nested object’ların özel bir durumu olan companion object’lara bakalım. */