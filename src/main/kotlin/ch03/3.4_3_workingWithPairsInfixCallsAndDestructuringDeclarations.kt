package ch03

val map = mapOf(
    1 to "one",
    7 to "seven",
    53 to "fifty-three"
)

/* Yukarıda ki kod satırındaki **to** kelimesi, yerleşik bir construct değildir; bunun yerine özel bir tür method
invocation’ıdır, yani infix call. Infix call’da method adı, target object name ile parameter arasında, ekstra bir
ayırıcı olmadan yerleştirilir. Aşağıdaki iki call eşdeğerdir:*/

// 1.to("one") -> Regular way
// 1 to "one"  -> Infix notation

/* Infix call’lar, tam olarak bir required parameter’a sahip regular method’lar ve extension function’larla
kullanılabilir. Bir function’ın infix notation ile çağrılabilmesini sağlamak için, onu infix modifier ile işaretlemeniz
gerekir. İşte **to** function’ının declaration’ının basitleştirilmiş bir versiyonu:*/

infix fun Any.to(other : Any) = Pair(this,other)

/* To function, bir Pair instance’ı döner; Pair, şaşırtıcı olmayan bir şekilde, bir çift element’i represent eden Kotlin
standard library class’ıdır. Asıl Pair ve to declaration’ları generic kullanır, fakat işleri basit tutmak için burada
onları atlıyoruz. Bir Pair içeriği ile iki variable’ı doğrudan initialize edebileceğinizi unutmayın:*/

fun test(){
    // Bu özellik, destructuring declaration olarak adlandırılır.
    val (number, value) = 1 to "one"
}

/* Destructuring-declaration özelliği sadece pair’larla sınırlı değildir. Örneğin, bir map entry’nin içeriği ile iki
variable, key ve value, da initialize edebilirsiniz*/

fun destructuringDeclaration(){
    val collection = listOf("1","2","3")
    for ((index,element) in collection.withIndex()){
        println("$index : $element")
    }
}

/* To function bir extension function’dır. Herhangi bir element çifti oluşturabilirsiniz, bu da generic bir receiver’a
extension olduğunu gösterir: 1 to "one", "one" to 1, list to list.size() gibi yazabilirsiniz. Şimdi mapOf function’ın
signature’ına bakalım:*/

// fun <K, V> mapOf(vararg values: Pair<K, V>): Map<K, V>

/* ListOf gibi, mapOf da variable sayıda argument kabul eder, fakat bu sefer bunlar key ve value çiftleri olmalıdır.
Yeni bir map oluşturmak Kotlin’de özel bir construct gibi görünse de, aslında kısa bir syntax’a sahip regular bir
function’dır.*/