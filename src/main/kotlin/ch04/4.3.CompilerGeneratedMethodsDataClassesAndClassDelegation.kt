package ch04

/* Java platformu, birçok class’ta bulunması gereken ve genellikle mekanik bir şekilde implement edilen çeşitli
method’lar tanımlar; örneğin equals (iki object’in birbirine eşit olup olmadığını belirtir), hashCode (hash map gibi
data structure’lar tarafından gerekli olan object için bir hash code sağlar) ve toString (object’in metinsel temsilini
döndürür). Neyse ki, IDE’ler bu method’ların generation’ını otomatikleştirebilir, bu yüzden genellikle onları elle
yazmanız gerekmez. Ancak bu durumda, codebase’iniz yine de bakımını yapmanız gereken boilerplate code içerir. Kotlin
compiler, bir adım daha ileri gider: mekanik code generation’ı arka planda gerçekleştirir ve sonuçlarla source code
file’larınızı doldurmaz. Trivial class constructor ve property accessor’lar için bunun nasıl çalıştığını zaten gördünüz.
Şimdi, Kotlin compiler’ın basit data class’lar için faydalı tipik method’ları nasıl generate ettiğine ve
class-delegation pattern’ını nasıl büyük ölçüde basitleştirdiğine dair daha fazla örneğe bakalım. */

/* Trivial constructor, sadece parametre ataması yapan ve başka hiçbir işlem yapmayan constructor’dır. Compiler için
“simple” olduğundan ekstra bytecode veya init bloğu oluşturmasına gerek yoktur. Aşağıda ki constructor trivial’dır çünkü
sadece property’leri atıyor (name ve age). Getter/setter’lar ve field ataması dışında başka işlem yok. Setter olabilmesi
için tabii ki var keyword'u ile marklanmalı*/

class Person43Trivial(val name: String, val age: Int)

/* Not-trivial constructor, ekstra operation veya computation yapan constructor’dır. Örneğin init bloğu, default değer
hesaplaması, logging veya başka side-effect’ler içeriyorsa, compiler bunu trivial olarak kabul etmez. */

class Person43NonTrivial(val name : String, val birthYear : Int){
    val age : Int = 2025 - birthYear
}

/* Trivial Accessor, eğer bir property sadece backing field’e direkt erişiyorsa ve getter/setter hiç ekstra işlem
yapmıyorsa, bu accessor trivial olarak kabul edilir. Compiler için bytecode çok basittir: field okuma/yazma işlemi
dışında ekstra işlem yoktur. */

class Person43TrivialAccessor(var name : String) // Otomatik getter/setter üretir

/* Non-Trivial Accessor, eğer getter veya setter ekstra işlem yapıyorsa (hesaplama, loglama, validation, başka
property’ye atama vb.), accessor not-trivial olur. Bu durumda compiler, trivial field erişimi yerine özel bytecode
üretir.*/

class Person43NonTrivialAccessor(var birthYear : Int){
    var age2050 : Int
        get() = 2050 - birthYear
        set(value){
            birthYear = 2050 - value
        }
}

/* Burada ageIn2050 için backing field yok, getter/setter değerleri birthYear üzerinden hesaplıyor. Compiler trivial
field ataması yapamıyor → accessor non-trivial.*/