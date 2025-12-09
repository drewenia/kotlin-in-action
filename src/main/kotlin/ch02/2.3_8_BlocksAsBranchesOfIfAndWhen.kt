package ch02

/* Hem if hem de when, branch olarak block’lara sahip olabilir. Bu durumda, block içindeki son expression sonuçtur.
Diyelim ki eval function’ının sonucu nasıl hesapladığını daha derinlemesine anlamak istiyorsun. Bunu yapmanın bir yolu,
function’ın şu anda neyi hesapladığını loglayan println ifadeleri eklemektir. Bunları when expression’ındaki her branch
için block içine ekleyebilirsin. Block içindeki son expression ise return edilecek olandır. */

interface Expr238
class Num238(val value: Int) : Expr238
class Sum238(val left: Expr238, val right: Expr238) : Expr238

fun eval238(e: Expr238): Int =
    when (e) {
        is Num238 -> {
            println("num : ${e.value}")
            e.value
        }

        is Sum238 -> {
            val left = eval238(e.left)
            val right = eval238(e.right)
            println("Sum -> $left + $right")
            left + right
        }

        else -> throw IllegalArgumentException("Unknown type")
    }

fun main() {
    val eval238 = eval238(
        Sum238(
            Sum238(Num238(1), Num238(2)),
            Num238(4)
        )
    )
    println(eval238)
}

/* Bir block’un son expression’ının sonuç olması kuralı, block’un kullanılabildiği ve bir sonuç beklendiği tüm
durumlarda geçerlidir. Aynı kural try body ve catch clause’ları için de geçerlidir; Bu kuralın lambda expression’lara
uygulanmasını tartışacağız. Ancak bu kural normal function’lar için geçerli değildir. Bir function ya block olamayan bir
expression body’ye ya da içinde explicit return ifadeleri bulunan bir block body’ye sahip olabilir. */