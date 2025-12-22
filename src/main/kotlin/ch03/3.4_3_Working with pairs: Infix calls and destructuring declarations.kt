package ch03

/* Map oluşturmak için mapOf function’ını kullanırsın: */

val map = mapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

/* Bu code satırındaki **to** kelimesi built-in bir construct değildir; özel bir türde method invocation’dır: infix
call. Bir infix call’da, method adı target object adı ile parameter arasına, herhangi bir ek ayraç olmadan
yerleştirilir. Aşağıdaki iki call eşdeğerdir:

1.to("one") -> regular way
1 to "one" -> infix notation
*/

/* Infix call’lar, tam olarak bir required parameter’a sahip olan regular method’lar ve extension function’larla
kullanılabilir. Bir function’ın infix notation kullanılarak call edilebilmesi için, onu infix modifier’ı ile
işaretlemen gerekir. İşte to function’ının declaration’ının sadeleştirilmiş bir versiyonu: */

infix fun Any.to(other: Any) = Pair(this,other)

// val (number,name) = 1 to "one"

/* to function’ı, Kotlin standard library’de bulunan ve şaşırtıcı olmayacak şekilde bir element çifti represent eden
Pair class’ının bir instance’ını döndürür. Pair ve to’nun gerçek declaration’ları generic kullanır, ancak burada işleri
basit tutmak için bunları atlıyoruz. Bir Pair’ın contents’i ile iki variable’ı doğrudan initialize edebileceğini
unutma: Bu feature, destructuring declaration olarak adlandırılır. img_1.png bunun pair’lerle nasıl çalıştığını
gösterir. to function’ını kullanarak bir pair oluşturur ve onu bir destructuring declaration ile unpack edersin.
Destructuring declaration feature’ı yalnızca pair’lerle sınırlı değildir. Örneğin, bir map entry’sinin contents’i ile
key ve value adlı iki variable’ı da initialize edebilirsin. Bu, joinToString implementasyonu içinde gördüğün gibi
loop’larla da çalışır; burada withIndex function’ı kullanılır.

for ((index, element) in collection.withIndex()) {
    println("$index: $element")
}
*/

/* to function’ı bir extension function’dır. Herhangi element’lerden bir pair oluşturabilirsin; bu da onun generic bir
receiver’a extension olduğu anlamına gelir: 1 to "one", "one" to 1, list to list.size() vb. yazabilirsin. Şimdi mapOf
function’ının signature’ına bakalım:

fun <K, V> mapOf(vararg values: Pair<K, V>): Map<K, V>
*/

/* ListOf gibi, mapOf da variable sayıda argument kabul eder; ancak bu sefer bunların key ve value pair’leri olması
gerekir. Yeni bir map oluşturma Kotlin’de özel bir construct gibi görünebilse de, aslında özlü bir syntax’a sahip
regular bir function’dır. */

