package ch03

/* Bu method, bir method’a istediğiniz sayıda value geçirebilmenizi sağlayan bir language özelliğini kullanır: varargs.
Kotlin’in varargs’ı Java’dakine benzerdir, fakat syntax biraz farklıdır: type’tan sonra üç nokta yerine, Kotlin
parametre üzerinde vararg modifier’ını kullanır. Kotlin ve Java arasındaki bir diğer fark, argument’lerin zaten bir
array içinde paketlendiği durumlarda function’ı çağırma syntax’ıdır. Java’da array’i olduğu gibi geçirirsiniz, oysa
Kotlin’de her array element’inin çağrılan function’a ayrı bir argument olmasını sağlamak için array’i açıkça unpack
etmeniz gerekir. Bu özellik spread operator olarak adlandırılır ve kullanımı, ilgili argument’in önüne * karakteri
koymak kadar basittir. Bu snippet’te, main function’ınıza geçen command-line argument’leri içeren args array’ini,
listOf function’ı için variable argument’lar olarak kullanmak üzere “spread” ediyorsunuz:

Bu örnek, spread operator’ün bir array içindeki value’ları ve bazı sabit value’ları tek bir call içinde birleştirmenizi
sağladığını gösterir. Bu Java’da desteklenmez.
*/

fun main(args: Array<String>) {
    // * spread operatörü array content'ini unpack eder
    val list = listOf("args :", *args)
    println(list)
}