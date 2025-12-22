package ch04

/* Varsayılan olarak, accessor’ın visibility’si property ile aynıdır. Ancak gerekirse, get veya set keyword’ünden önce
bir visibility modifier koyarak bunu değiştirebilirsiniz. Bunu nasıl kullanabileceğinizi görmek için, eklenen
kelimelerin toplam uzunluğunu takip eden küçük bir class olan LengthCounter örneğine bakalım. */

class LengthCounter425{
    var counter : Int = 0
        // Bu property’yi class dışında değiştiremezsiniz.
        private set
    fun addWord(word : String) {
        counter += word.length
    }
}

/*
fun LengthCounter425.addWord425(word : String){
    // error
    counter += word.length
}
*/

/* Toplam uzunluğu tutan counter property’si public’tir, çünkü class’ın client’larına sağladığı API’nin bir parçasıdır.
Ancak, yalnızca class içinde değiştirilmesini sağlamak gerekir; aksi takdirde external code, değeri değiştirip yanlış
bir value saklayabilir. Bu nedenle, Compiler’ın varsayılan visibility ile bir getter üretmesine izin verir ve setter’ın
visibility’sini private yaparsınız. İşte bu class’ı nasıl kullanabileceğiniz: */

fun main() {
    val lengthCounter = LengthCounter425()
    lengthCounter.addWord("Hello, World!")
    println(lengthCounter.counter) // 13
}

/* LengthCounter’dan bir instance oluşturursunuz ve ardından uzunluğu 13 olan "Hello, World!" kelimesini eklersiniz.
Şimdi counter property’si 13 değerini saklar. Beklendiği gibi, class dışından property’ye yazmaya çalışmak compile-time
error ile sonuçlanır:

lengthCounter.counter = 0
// Error: Cannot assign to 'counter': the setter is private in
➥ 'LengthCounter'
*/

/*
Non-null bir property üzerinde lateinit modifier, bu property’nin constructor çağrıldıktan sonra, yani daha sonra
initialize edileceğini belirtir; bu bazı framework’lerde yaygın bir durumdur. Bu özellik daha sonra ele alınacaktır.

Lazy initialized property’ler, daha genel delegated property özelliğinin bir parçası olarak, daha sonra ele alınacaktır.

Java framework’leri ile uyumluluk için, Kotlin’de Java özelliklerini taklit eden annotation’lar kullanabilirsiniz.
Örneğin, bir property üzerindeki @JvmField annotation’ı, accessor’lar olmadan public bir field açığa çıkarır.
Annotation’lar hakkında daha fazlasını daha sonra öğreneceksiniz.

const modifier, annotation’larla çalışmayı daha uygun hâle getirir ve primitive type veya String türündeki bir
property’yi annotation argümanı olarak kullanmanıza olanak tanır.
*/

/* Böylece Kotlin’de nontrivial constructor ve property’ler yazma konusundaki tartışmamızı tamamlamış olduk. Sırada,
birden fazla bilgiyi tutmayı daha kolay hâle getirmeyi amaçlayan class’lar: data class’lar kullanımı var. */