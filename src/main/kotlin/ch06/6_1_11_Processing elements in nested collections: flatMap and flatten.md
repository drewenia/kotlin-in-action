# Processing elements in nested collections: flatMap and flatten

Book class’ı tarafından represent edilen bir kitap collection’ına sahip olduğunuzu varsayalım:

```kotlin
class Book(val title: String, val authors: List<String>)
```

Her bir kitap bir veya daha fazla author tarafından yazılmıştır ve library’nizde bir dizi kitap bulunmaktadır:

```kotlin
val library = listOf(
    Book("Kotlin in Action", listOf("Isakova", "Elizarov", "Aigner", "Jemerov")),
    Book("Atomic Kotlin", listOf("Eckel", "Isakova")),
    Book("The Three-Body Problem", listOf("Liu"))
)
```

Library’nizdeki tüm author’ları compute etmek istiyorsanız, 6.1.1 bölümünde tanıdığınız map function’ı kullanarak
başlayabilirsiniz:

```kotlin
fun main() {
    val library = listOf(
        Book("Kotlin in Action", listOf("Isakova", "Elizarov", "Aigner", "Jemerov")),
        Book("Atomic Kotlin", listOf("Eckel", "Isakova")),
        Book("The Three-Body Problem", listOf("Liu"))
    )

    val map = library.map { it.authors }
    println(map) // [[Isakova, Elizarov, Aigner, Jemerov], [Eckel, Isakova], [Liu]]
}

class Book(val title: String, val authors: List<String>)
```

Büyük olasılıkla, aklınızdaki sonuç bu değildir. Çünkü authors başlı başına bir List<String> olduğundan, ortaya çıkan
collection bir List<List<String>> olur — yani nested bir collection. flatMap function ile, library’nizdeki tüm
author’ların set’ini, ekstra bir nesting olmadan hesaplayabilirsiniz. İki şey yapar: önce, bir argument olarak verilen
function’a göre her bir element’i bir collection’a dönüştürür (map function’da gördüğünüz gibi), ardından bu list’leri
birleştirir (ya da flatten eder).

```kotlin
fun main() {
    val library = listOf(
        Book("Kotlin in Action", listOf("Isakova", "Elizarov", "Aigner", "Jemerov")),
        Book("Atomic Kotlin", listOf("Eckel", "Isakova")),
        Book("The Three-Body Problem", listOf("Liu"))
    )
    val flatten = library.flatMap { it.authors }
    println(flatten.toSet()) // [Isakova, Elizarov, Aigner, Jemerov, Eckel, Liu]
}

class Book(val title: String, val authors: List<String>)
```

Her bir kitap birden fazla author tarafından yazılabilir ve book.authors property’si author’ların bir list’ini saklar.
Yukarıda ki kod da, tüm kitapların author’larını tek ve düz bir list içinde birleştirmek için flatMap function’ı
kullanırsınız. toSet çağrısı, ortaya çıkan collection’dan duplicate’leri kaldırır — bu örnekte, Svetlana Isakova çıktıda
yalnızca bir kez listelenir. Bir element collection’larının collection’ı (örneğin, List<List<Int>>) ile karşı karşıya
kaldığınızda ve bunların tek bir collection (yani List<Int>) hâline getirilmesi gerektiğinde flatMap’i düşünebilirsiniz.

Herhangi bir şeyi transform etmeniz gerekmiyorsa ve yalnızca bu tür bir collection of collections’ı düzleştirmeniz
gerekiyorsa, flatten function’ı kullanabilirsiniz: listOfLists.flatten().

```kotlin
fun main() {
    val list = listOf(
        listOf("Apple", "Banana"),
        listOf("Milk", "Cheese", "Yoghurt"),
        listOf("Bread")
    )

    println(list) // [[Apple, Banana], [Milk, Cheese, Yoghurt], [Bread]]

    val flatten = list.flatten()
    println(flatten) // [Apple, Banana, Milk, Cheese, Yoghurt, Bread]
}
```

Kotlin standard library’deki bazı collection operation function’larını vurguladık, ancak çok daha fazlası vardır. Yer
kısıtlamaları nedeniyle ve uzun bir function listesi göstermenin sıkıcı olması sebebiyle hepsini ele almayacağız.
Collection’larla çalışan kod yazarken genel tavsiyemiz, yapılacak operation’ın genel bir transformation olarak nasıl
ifade edilebileceğini düşünmeniz ve böyle bir transformation’ı gerçekleştiren bir standard library function’ı
aramanızdır — bunu ya IDE’nizin autocomplete önerilerine bakarak ya da Kotlin standard library
referansına (https://kotlinlang.org/api/latest/jvm/stdlib/) danışarak yapabilirsiniz. Büyük olasılıkla bir tane bulacak
ve problemi manuel bir implementation’a kıyasla çok daha hızlı çözeceksiniz.

Şimdi, collection operation’larını zincirleyen kodun performance’ına daha yakından bakalım. Bir sonraki bölümde, bu tür
operation’ların hangi farklı yollarla execute edilebildiğini göreceksiniz.









