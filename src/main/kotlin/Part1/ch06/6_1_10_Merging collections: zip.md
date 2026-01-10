# Merging collections: zip

Bazen, ilişkili data içeren ayrı list’lerle çalışmanız ve bu bilgileri aggregate etmeniz gerekebilir. Örneğin, Person
object’lerinden oluşan tek bir list yerine, sırasıyla kişilerin isimlerini ve yaşlarını içeren iki ayrı list’iniz
olabilir. Her bir list’teki value’ların index’lerine göre birbiriyle örtüştüğünü biliyorsanız (yani index 0’daki isim
Joe, index 0’daki yaş 22’ye karşılık geliyorsa), zip function’ı kullanarak iki collection’daki aynı index’te bulunan
value’lardan oluşan bir pair list’i oluşturabilirsiniz. Function’a bir lambda geçirmek, çıktının nasıl transform
edileceğini de belirtmenize olanak tanır. Bu örnekte, her bir isim ve yaş pair’inden Person object’lerinden oluşan bir
list oluşturuyorsunuz.

zip function, kendisine geçirdiğiniz lambda’yı kullanarak iki input’taki her bir element’i aynı index’te eşleştirir;
aksi hâlde element’lerin pair’lerini oluşturur. Diğer collection’da bir karşılığı olmayan element’ler göz ardı edilir:

![img_11.png](assets/img_11.png)

```kotlin
fun main() {
    val names = listOf("Joe", "Mary", "Jamie")
    val ages = listOf(22, 31, 31, 44, 0)
    val zipped = names.zip(ages)

    // Diğer collection’da bir karşılığı olmayan value’lar, zip tarafından göz ardı edilir.
    println(zipped) // [(Joe, 22), (Mary, 31), (Jamie, 31)]

    val zippedPerson = names.zip(ages) { name, age -> Person(name, age) }
    println(zippedPerson)
    // [Person(name=Joe, age=22), Person(name=Mary, age=31), Person(name=Jamie, age=31)]
}

data class Person(val name: String, val age: Int)
```

Ortaya çıkan collection’ın size’ının, iki list’ten daha kısa olanla aynı olduğunu unutmayın: zip yalnızca her iki input
collection’da da var olan index’lerdeki item’ları işler. Pair object’leri oluşturmak için kullanılan to function gibi,
zip function da infix function olarak çağrılabilir (bölüm 3.4.3’te tanıtıldığı üzere) — ancak bu durumda transforming
bir lambda geçemezsiniz:

```kotlin
fun main() {
    val names = listOf("Joe", "Mary", "Jamie")
    val ages = listOf(22, 31, 31, 44, 0)

    println(names zip ages) // [(Joe, 22), (Mary, 31), (Jamie, 31)]
}
```

Diğer tüm function’lar gibi, infix syntax kullanırken bile, ikiden fazla list’i birleştirmek için birden fazla zip
çağrısını zincirleyebilirsiniz. Ancak zip her zaman iki list üzerinde çalıştığı için, ortaya çıkan structure’ın basitçe
list’lerden oluşan bir list yerine, iç içe geçmiş pair’lerden oluşacağını göz önünde bulundurmanız gerekir:

```kotlin
fun main() {
    val names = listOf("Joe", "Mary", "Jamie")
    val ages = listOf(22, 31, 31, 44, 0)
    val countries = listOf("DE", "NL", "US")

    /* Birden fazla zip çağrısını birleştirmek, nested pair’lerden oluşan bir list ile sonuçlanır. İsimler ve yaşlar 
    etrafındaki ekstra parantezlere dikkat edin. */
    println(names zip ages zip countries) // [((Joe, 22), DE), ((Mary, 31), NL), ((Jamie, 31), US)]
}
```