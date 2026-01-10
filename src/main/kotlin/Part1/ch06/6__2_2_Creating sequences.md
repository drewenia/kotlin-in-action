# Creating sequences

Önceki örnekler, bir sequence oluşturmak için aynı yöntemi kullandı: bir collection üzerinde asSequence() çağırdın.
Başka bir olasılık ise generateSequence fonksiyonunu kullanmaktır. Bu fonksiyon, bir sequence içindeki bir sonraki
element’i, bir önceki element’e bağlı olarak hesaplar. Örneğin, generateSequence kullanarak 100’e kadar olan tüm doğal
sayıların toplamını şu şekilde hesaplayabilirsin. Önce tüm doğal sayıların bulunduğu bir sequence üretirsin. Daha sonra,
bu sequence’ten 100’e eşit veya 100’den küçük olan element’leri almak için takeWhile fonksiyonunu kullanırsın. Son
olarak, bu sayıların toplamını hesaplamak için sum kullanırsın.

```kotlin
fun main() {
    val naturalNumbers = generateSequence(0) { it + 1 }
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }

    // Tüm delayed operation'lar, result sum elde edildiğinde gerçekleştirilir.
    println(numbersTo100.sum()) // 5050
}
```

Bu örnekte naturalNumbers (infinite bir sequence) ve numbersTo100 (finite bir sequence) her ikisi de postponed
(ertelenmiş) computation'a sahip sequence’lerdir. Bu sequence’lerdeki actual (gerçek) numbers (sayılar), terminal
operation’ı (bu durumda sum) çağırana kadar evaluate (değerlendirilmez) edilmez.

Bir diğer yaygın use case, parents sequence’idir. Bir element kendi type’ına ait parents’lara sahipse, tüm
ancestors’larının (atalarını) sequence’inin nitelikleriyle ilgilenebilirsin. Bunun tipik örnekleri, bir insanın
lineage’ı (soy) ya da belirli bir file için parent folder structure olabilir (JVM üzerinde hem files hem de folders
genellikle aynı type ile represent edilir: File). Aşağıdaki örnekte, parent directories’inin bir sequence’ini generate
ederek ve bu attribute’ü her bir directory üzerinde kontrol ederek, file’ın gizli bir directory içinde locate edilip
edilmediğini sorgularsın.

```kotlin
fun File.isInsideHiddenDirectory() =
    generateSequence(this) { it.parentFile }.any { it.isHidden }

fun main() {
    val file = File("/Users/svtk/.HiddenDir/a.txt")
    println(file.isInsideHiddenDirectory())
    // true
}
```

Bir kez daha, ilk element’i ve her bir sonraki element’i elde etmenin bir yolunu sağlayarak bir sequence generate
edersin. any yerine find kullanarak, path içinde bir yerde gizli bir file olduğunu belirten yalnızca bir Boolean value
yerine, gizli olan gerçek directory’yi elde edersin. sequence’leri kullanmanın, gerekli directory’yi bulur bulmaz
parents üzerinde traversing işlemini durdurmana olanak tanıdığını unutma.

Örneğimizde ki ```generateSequence(this) { it.parentFile }``` ifadesini adım adım parçalayalım:

generateSequence iki şeye ihtiyaç duyar:

* Seed : Başlangıç değeri. Senin örneğinde bu ```this``` (yani dosyanın kendisi).

* Next Function: Bir önceki elemanı alıp bir sonrakini üreten fonksiyon. Senin örneğinde bu ```{ it.parentFile }```

Diyelim ki dosya yolun: "/Users/svtk/.HiddenDir/a.txt"

1. Eleman (Seed): /Users/svtk/.HiddenDir/a.txt

2. Eleman (Next): Bir öncekinin parentFile'ı -> /Users/svtk/.HiddenDir

3. Eleman (Next): Bir öncekinin parentFile'ı -> /Users/svtk

4. Eleman (Next): Bir öncekinin parentFile'ı -> /Users

5. Eleman (Next): Bir öncekinin parentFile'ı -> / (Root)

6. Eleman (Next): Bir öncekinin parentFile'ı -> null (Burada durur!)

generateSequence fonksiyonu, ürettiği değer null olduğu anda durur. Yani yukarıdaki tüm klasör yapısını bir liste gibi
sırayla gezer.

```.any { it.isHidden }``` Ne Yapıyor? Bu sequence oluşturulurken any fonksiyonu her elemanı kontrol eder:

* a.txt gizli mi? Hayır.

* .HiddenDir gizli mi? Evet! (Çünkü ismi nokta ile başlıyor).

any fonksiyonu bir tane "true" bulduğu anda taramayı durdurur ve sonucu true döner.