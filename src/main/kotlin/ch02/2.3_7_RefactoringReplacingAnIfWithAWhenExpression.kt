package ch02

/* if’in Kotlin’de bir expression olduğunu zaten görmüştün. Bu aynı zamanda Kotlin’de ternary operator bulunmamasının
sebebidir — if expression zaten bir value döndürebilir. Bu da eval function’ını expression-body syntax kullanacak
şekilde yeniden yazabileceğin anlamına gelir; return ifadesini ve süslü parantezleri kaldırır ve if expression’ını
function body olarak kullanırsın. */

interface Expr237
class Number237(val value: Int) : Expr237
class Sum237(val left: Expr237, val right: Expr237) : Expr237

fun eval237(e: Expr237): Int =
    if (e is Number237) {
        e.value
    } else if (e is Sum237) {
        eval237(e.right) + eval237(e.left)
    } else {
        throw IllegalArgumentException("Unknown type")
    }

fun main() {
    val eval237 = eval237(
        Sum237(
            Sum237(Number237(1), Number237(2)),
            Number237(4)
        )
    )
    println(eval237)
}

/* Ve bu code’u daha da özlü hâle getirebilirsin: Bir if branch’inde yalnızca tek bir expression varsa süslü parantezler
isteğe bağlıdır — bir block içeren if branch’inde ise son expression sonuç olarak döndürülür. Zincirleme if
expression’ları kullanan kısaltılmış bir eval expression’ı şöyle görünebilir: */

fun eval237v2(e: Expr237): Int =
    if (e is Number237) e.value
    else if (e is Sum237) eval237v2(e.left) + eval237v2(e.right)
    else throw IllegalArgumentException("Unknown type")

/* Birden fazla seçeneği ifade etmek için çok daha iyi bir language construct ile tanıştın — hadi bu code’u biraz daha
cilalayalım ve when kullanarak yeniden yazalım. When expression’ı, daha önce gördüğün gibi yalnızca value’ları eşitlik
açısından kontrol etmekle sınırlı değildir. Burada, when branch’lerinin farklı bir formunu kullanırsın; bu form, when
argüman value’sunun type’ını kontrol etmeni sağlar. if örneğinde olduğu gibi, type check bir smart cast uygular; böylece
Num ve Sum member'larına ekstra cast yapmadan erişebilirsin. */

fun eval237v3(e: Expr237) : Int =
    when(e){
        is Number237 -> e.value
        is Sum237 -> eval237v3(e.left) + eval237v3(e.right)
        else -> throw IllegalArgumentException("unknown type")
    }

/* Son iki Kotlin eval function versiyonunu karşılaştır ve kendi code’unda ardışık if expression’ları yerine when
kullanmayı nasıl uygulayabileceğini düşün. Birden fazla operation içeren branch logic’inde, branch body olarak bir
block expression kullanabilirsin. Şimdi bunun nasıl çalıştığına bakalım. */