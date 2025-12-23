package ch04

import kotlin.random.Random

/* Bir companion object, bir class içinde declare edilen normal bir object’tir. Diğer object declaration’lar gibi,
isimlendirilebilir, bir interface implement edebilir ya da extension function veya property’lere sahip olabilir. Bu
bölümde bir örneğe bakacağız. Bir şirketin payroll’u (maaş bordrosu) için bir web service üzerinde çalıştığını ve
object’leri JSON olarak serialize ve deserialize etmen gerektiğini varsayalım. Serialization logic’ini bir companion
object içinde konumlandırabilirsin. */

class Person443(val name: String) {
    companion object Loader {
        fun fromJSON(jsonText: String): Person443 {
            val nameValue = jsonText
                .substringAfter("\"name\"")
                .substringAfter(":")
                .substringAfter("\"")
                .substringBefore("\"")

            return Person443(nameValue)
        }
    }
}

fun main() {
    val person = Person443.Loader.fromJSON("""{"name":"Dimitry"}""")
    println(person.name) // Dimitry

    val person2 = Person443.fromJSON("""{"name":"Brent"}""")
    println(person2.name) // Brent

    companionRandom443()
}

/* Çoğu durumda companion object’e, onu içeren class’ın name’i üzerinden referans verirsin; bu nedenle ismiyle
ilgilenmene gerek yoktur. Ancak gerekirse, Person443’teki gibi ona bir isim verebilirsin: companion object Loader. Bir
class yalnızca bir companion object’e sahip olabilir ve ona bir isim verip vermemenden bağımsız olarak, member’larına
her zaman class name üzerinden erişebilirsin. Companion object’in ismini belirtmezsen, ona atanan varsayılan isim
Companion olur. “Companion-object extensions” başlıklı bölümde bu ismin kullanıldığı bazı örnekler göreceksin. Kotlin
standard library’de de bu tür singleton companion object’ların birçoğunu bulabilirsin. Örneğin, Kotlin’in Random class’ı
için Default companion object’i, default random number generator’a erişim sağlar: */

fun companionRandom443() {
    val chance = Random.nextInt(from = 0, until = 100)
    val coin = Random.Default.nextBoolean()
    println("Chance : $chance, Coin : $coin")
}

/*
COMPANION OBJECT’LERDE INTERFACE IMPLEMENT ETME

Diğer tüm object declaration’lar gibi, bir companion object de interface’leri implement edebilir. Birazdan göreceğin
gibi, interface’i implement eden bir object’in instance’ı olarak doğrudan containing class’ın name’ini kullanabilirsin.
Sistemde Person dâhil olmak üzere birçok türde object’in olduğunu varsayalım. Tüm türlerdeki object’leri oluşturmak için
ortak bir yol sağlamak istiyorsun. JSON’dan deserialize edilebilen object’ler için JSONFactory adında bir interface’in
olduğunu ve sistemindeki tüm object’lerin bu factory üzerinden oluşturulması gerektiğini düşünelim. Person class’ı için
bu interface’in bir implementation’ını companion object aracılığıyla sağlayabilirsin.
*/

// Beni implement eden bir şey, JSON’dan T üretebilir. Bu bir factory contract.
interface JSONFactory443<T> {
    fun fromJSON(jsonText: String): T
}

class Person443v2(val name: String) {
    // Interface implement eden companion object
    // companion object gerçek bir object
    // Yani Person443v2.Companion bir JSONFactory443<Person443v2>
    companion object : JSONFactory443<Person443v2> {
        override fun fromJSON(jsonText: String): Person443v2 {
            val nameValue = jsonText
                .substringAfter("\"name\"")
                .substringAfter(":")
                .substringAfter("\"")
                .substringBefore("\"")

            return Person443v2(nameValue)
        }
    }
}

/* Daha sonra, entity’leri yüklemek için abstract factory kullanan bir function’ın varsa, ona Person object’ini
geçirebilirsin: Person class’ının name’inin, JSONFactory’nin bir instance’ı olarak kullanıldığına dikkat et. */

/*
fun <T> loadFromJSON(factory : JSONFactory443<T>) : T{
    ...
}

loadFromJSON(Person)
*/

/* Bir class’ın companion object’i, normal bir object’e benzer şekilde compile edilir: class içindeki static bir field,
onun instance’ına referans verir. Companion object isimlendirilmemişse, Java code’undan Companion referansı üzerinden
erişilebilir:

/* Java */
Person.Companion.fromJSON("...");
*/

/* Eğer bir companion object’in bir name’i varsa, Companion yerine bu name’i kullanırsın. Ancak Java code’u ile
çalışman gerekebilir ve bu code, class’ının bir member’ının static olmasını isteyebilir. Bunu, ilgili member üzerinde
@JvmStatic annotation’ını kullanarak sağlayabilirsin. Static bir field declare etmek istiyorsan, top-level bir property
üzerinde ya da bir object içinde declare edilen bir property üzerinde @JvmField annotation’ını kullanırsın. Bu
feature’lar özellikle interoperability amaçları için vardır ve strictly speaking, core language’ın bir parçası değildir.
Kotlin’in, Java class’larında declare edilmiş static method ve field’lara Java ile aynı syntax’ı kullanarak
erişebildiğini de unutma. */

/*
COMPANION-OBJECT EXTENSION’LAR :

Extension function’lar codebase’in başka bir yerinde define edilmiş bir class’ın instance’ları üzerinde call edilebilen
method’lar tanımlamana olanak tanır. Peki ya class’ın kendisi üzerinde, companion object method’larıyla aynı syntax’ı
kullanarak call edilebilen function’lar define etmen gerekiyorsa? Eğer class’ın bir companion object’i varsa, bunu onun
üzerinde extension function’lar define ederek yapabilirsin. Daha spesifik olarak, eğer C class’ının bir companion
object’i varsa ve C.Companion üzerinde func adlı bir extension function define edersen, onu C.func() şeklinde call
edebilirsin. Örneğin, Person class’ı için daha temiz bir separation of concerns istediğini hayal et. Class’ın kendisi
core business logic module’ünün bir parçası olacaktır, ancak bu module’ü belirli bir data format’ına bağlamak
istemezsin. Bu nedenle, deserialization function’ının client–server communication’dan sorumlu module içinde define
edilmesi gerekir. Deserialization function’ını call etmek için aynı hoş syntax’ı korumak amacıyla, aşağıdaki code’da
gösterildiği gibi companion object üzerinde bir extension function kullanabilirsin. Açıkça bir name verilmeden declare
edilmiş companion object’e referans vermek için default name olan Companion’ı nasıl kullandığına dikkat et. */

// business logic module
class Person443v3 (val firstName : String, val lastName : String){
    // Boş bir companion object declare eder
    companion object{
    }
}

// client/server communication module

/*fun Person443v3.Companion.fromJSON(json : String) : Person443v3{
    ...
}

val p = Person.fromJSON(json)

*/

/* fromJSON’u, companion object’in bir method’uymuş gibi call edersin; ancak aslında o, extension function olarak onun
dışında define edilmiştir. Her zaman olduğu gibi, bu extension function bir member gibi görünür, fakat değildir
(ve diğer extension function’larda olduğu gibi, bir companion object’i extend etmek onun private member’larına erişim
sağlamaz). Ancak şuna dikkat et: Ona extension define edebilmek için, class’ında boş bile olsa bir companion object
declare etmen gerekir. Companion object’lerin ne kadar kullanışlı olabildiğini gördün. Şimdi, Kotlin’de aynı object
keyword’ü ile ifade edilen bir sonraki feature’a geçelim: object expression’lar. */