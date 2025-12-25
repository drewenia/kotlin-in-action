package ch05

/* Şimdiye kadar, member reference’larımız her zaman bir class’ın member’ına işaret ediyordu. Bound callable
reference’lar kullanarak, aynı member reference syntax’ını belirli bir object instance üzerindeki bir method’a reference
capture etmek için kullanabiliriz. Bu example’da, variable personsAgeFunction normal bir member reference’dır: Person
type’ında bir object parametre olarak verildiğinde, invoke edildiğinde o kişinin age’ini döndürür. sebastianAgeFunction
ise, invoke edildiğinde belirli bir kişinin age’ini döndürür (ve bu nedenle hiç argument almaz): */

data class Person516(val name: String, val age: Int)

fun boundCallableReferenceExample516() {
    val sebastian = Person516("Sebastian", 26)

    // Verilen bir kişinin age’ini döndüren member reference
    val personAgeFunction = Person516::age
    // Person object’ını bir argument olarak alır.
    println(personAgeFunction(sebastian)) // 26

    // Belirli bir kişinin age’ini döndüren bound member reference
    val sebastionAgeFunction = sebastian::age
    // Belirli bir object’e bound edilir ve hiç argument almaz.
    println(sebastionAgeFunction())
}

/* Gördüğün gibi, bu example’da sebastionAgeFunction’ı tanımlama şeklimiz — seb::age — lambda { seb.age }’i açıkça
yazmaya eşdeğerdir, fakat daha concise’tır (img_3.png). Normal bir member reference, örneğin Person::age, bir object
instance’ını parameter olarak alır ve member’in value’sunu döndürür. sebastian::age gibi bir bound member reference ise
hiç argument almaz ve bağlı olduğu object’e ait member’in value’sunu döndürür. Sonraki bölümde, lambda expression’larla
ve member reference’larla çok iyi çalışan birçok library function’a bakacağız. Lambda expression’ların sık kullanılan
bir uygulamasını kapsamlı bir şekilde ele aldık: collection’ları manipulate etmeyi basitleştirmek için kullanmak. Şimdi,
başka bir önemli konuya devam edelim: mevcut bir Java API ile lambda’ları kullanmak. */

fun main() {
    boundCallableReferenceExample516()
}

/* EK AÇIKLAMA

Kotlin’de bound member reference, bir objeye bağlı (bound) üye fonksiyon veya property referansıdır. Yani referans,
zaten belirli bir instance’a bağlıdır, ve çağrıldığında o instance üzerinde çalışır.

Normal (unbound) member reference: String::length → herhangi bir String instance’ı alır ve length’ini döndürür. Instance
çağrıda verilir.

Bound member reference: "hello"::length → "hello" instance’ına bağlıdır, parametre verilmeye gerek yoktur.
*/