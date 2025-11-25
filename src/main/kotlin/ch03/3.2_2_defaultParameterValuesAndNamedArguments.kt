package ch03
/* Kotlin’de, function declaration’ında parameter’lar için default value belirtebildiğiniz için çoğu zaman overload
oluşturmaktan kaçınabilirsiniz. Bunu joinToString function’ını geliştirmek için kullanalım. Çoğu durumda, string’ler
herhangi bir prefix veya postfix olmadan virgülle ayrılabilir. O hâlde, bu değerleri varsayılan yapalım. */

fun <T> joinToStringWithDefaultValues(
    collection : Collection<T>,
    seperator : String = ", ",
    prefix: String = "",
    postfix : String = ""
) : String {
    val text = StringBuilder(prefix)
    for ((index,element) in collection.withIndex()){
        if(index > 0) text.append(seperator)
        text.append(element)
    }
    text.append(postfix)
    return text.toString()
}

fun main(){
    val list = listOf(1,2,3)
    println(joinToStringWithDefaultValues(list)) // 1, 2, 3
    println(joinToStringWithDefaultValues(list,"-","#","#")) // #1-2-3#

    /* Düzenli çağrı sözdizimini kullanırken, argümanları fonksiyon deklarasyonundaki aynı sırada belirtmek zorundasınız
    ve yalnızca sondaki argümanları atlayabilirsiniz. Eğer named arguments kullanırsanız, parametre listesinin
    ortasındaki bazı argümanları atlayabilir ve yalnızca ihtiyacınız olanları, istediğiniz herhangi bir sırada
    belirtebilirsiniz buna named arguments adı verilir*/
    println(joinToStringWithDefaultValues(list, postfix = ";",prefix = "# ")) // # 1, 2, 3;
}