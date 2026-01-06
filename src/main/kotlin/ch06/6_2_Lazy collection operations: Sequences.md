# Lazy collection operations: Sequences

Önceki bölümde, map ve filter gibi chained collection function’larına dair birkaç örnek gördünüz. Bu function’lar
intermediate (ara) collection’ları eagerly oluşturur; yani her adımın intermediate (ara) sonucu temporary (geçici) bir
list’te saklanır. Sequences, bu tür computation'ları, intermediate (ara) temporary object’lerin oluşturulmasından
kaçınarak gerçekleştirmek için alternatif bir yol sunar; Java 8’in streams’lerinin yaptığına benzer şekilde. İşte bir
örnek:

```kotlin
fun main() {
    val people = listOf(
        Person("Alex", 21),
        Person("Derek", 39),
        Person("Dimitri", 28),
        Person("Ari", 41),
    )

    val filtered = people.map(Person::name).filter { it.startsWith('A') }
    println(filtered) // [Alex, Ari]
}

data class Person(val name: String, val age: Int)
```

Kotlin standard library referansı, hem map hem de filter’ın bir list döndürdüğünü söyler. Bu da bu call zincirinin iki
list oluşturacağı anlamına gelir: biri map function’ın sonuçlarını tutmak için, diğeri ise filter’ın sonuçları için.
Source list iki element içerdiğinde bu bir problem değildir, ancak bir milyon element olduğunda çok daha az verimli hâle
gelir. Bunu daha verimli hâle getirmek için, operation’ı doğrudan collection’lar yerine sequences kullanacak şekilde
dönüştürebilirsiniz:

```kotlin
fun main() {
    val people = listOf(
        Person("Alex", 21),
        Person("Derek", 39),
        Person("Dimitri", 28),
        Person("Ari", 41),
    )

    val toList = people
        .asSequence() // Başlangıçtaki collection’ı Sequence’e dönüştürür
        .map(Person::name) // Sequences, collection’larla aynı API’yi destekler.
        .filter { it.startsWith('A') } // Sequences, collection’larla aynı API’yi destekler.
        .toList() // Ortaya çıkan Sequence’i tekrar bir list’e dönüştürür

    println(toList) // [Alex, Ari]
}

data class Person(val name: String, val age: Int)
```

Bu operation’ı uygulamanın sonucu, önceki örnektekiyle aynıdır: A harfiyle başlayan kişilerin isimlerinden oluşan bir
list. Ancak ikinci örnekte, element’leri saklamak için herhangi bir intermediate collection oluşturulmaz; bu nedenle çok
sayıda element için performance belirgin biçimde daha iyi olur.

Kotlin’de lazy collection operation’ları için giriş noktası Sequence interface’idir. Bu interface tam olarak bunu temsil
eder: element’lerin tek tek enumerate edilebildiği bir sequence. Sequence yalnızca tek bir method sağlar, iterator; bu
method’u kullanarak sequence’den value’ları elde edebilirsiniz.

Sequence interface’inin gücü, üzerindeki operation’ların uygulanma biçiminde yatar. Bir sequence içindeki element’ler
lazily evaluate edilir. Bu nedenle, sequence’leri kullanarak bir collection’ın element’leri üzerinde operation
zincirlerini, processing’in intermediate sonuçlarını tutacak collection’lar oluşturmadan verimli bir şekilde
gerçekleştirebilirsiniz. Ayrıca, map ve filter gibi normal list processing’inden zaten bildiğimiz function’ları
sequence’lerle birlikte de kullanabildiğimizi fark edeceksiniz. Herhangi bir collection, asSequence extension function’ı
çağrılarak bir sequence’e dönüştürülebilir. Ters dönüşüm için, yani bir sequence’i normal bir list’e çevirmek için ise
toList çağrılır.

Sequence’i neden tekrar bir collection’a dönüştürmeniz gerekir? Bu kadar iyilerse, collection’lar yerine sequence’leri
kullanmak daha kullanışlı olmaz mı? Cevap: bazen. Eğer yalnızca bir sequence içindeki element’ler üzerinde iteration
yapmanız gerekiyorsa, sequence’i doğrudan kullanabilirsiniz. Ancak element’lere index ile erişmek gibi başka API
method’larını kullanmanız gerekiyorsa, sequence’i bir list’e dönüştürmeniz gerekir.

Genel bir kural olarak, büyük bir collection üzerinde bir operation zinciri olduğunda sequence kullanın. 10.2 bölümünde,
regular collection’lar üzerindeki eager operation’ların, intermediate collection’lar oluşturmalarına rağmen Kotlin’de
neden verimli olduğunu tartışacağız. Ancak collection çok sayıda element içeriyorsa, element’lerin intermediate olarak
yeniden düzenlenmesi yüksek bir maliyete yol açar; bu nedenle lazy evaluation tercih edilir.

Sequence üzerindeki operation’lar lazy olduğu için, bunları gerçekleştirmek adına ya sequence’in element’leri üzerinde
doğrudan iteration yapmanız ya da onu bir collection’a dönüştürmeniz gerekir. Bir sonraki bölüm bu süreci açıklar.