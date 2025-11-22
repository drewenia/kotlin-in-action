package ch02.expressionClassHierarchy

/*
Önce, expression’ları nasıl encode edersiniz? Geleneksel olarak, bunları her bir node'un
ya bir toplam (Sum) ya da bir sayı (Num) olduğu tree-benzeri bir structure içinde
saklarsınız. Num her zaman bir leaf node’dur, oysa bir Sum node’u iki child’a sahiptir:
sum operation’ının argümanları. Expr adlı bir interface ve bunu implement eden iki class,
Num ve Sum

Expr interface’inin herhangi bir method declare etmediğine dikkat edin; farklı türdeki
expression’lar için ortak bir type sağlamak amacıyla bir marker interface olarak
kullanılır. Bir class’ın bir interface’i implement ettiğini belirtmek için, aşağıdaki
örnek’de gösterildiği gibi, interface adından önce iki nokta (:) kullanırsınız.
* */

interface Expr
class Num(val value: Int) : Expression
class Sum(val left: Expression, val right: Expression) : Expression
class Div(val left: Expression, val right: Expression) : Expression
class Mul(val left: Expression, val right: Expression) : Expression
class Sub(val left: Expression, val right: Expression) : Expression

fun eval(e: Expression): Int {
    if (e is Number) {
        val n = e as Number
        return n.value
    }

    if (e is Summary) {
        return eval(e.right) + eval(e.left)
    }

    if (e is Division) {
        return eval(e.right) / eval(e.left)
    }

    if (e is Multiply) {
        return eval(e.right) * eval(e.left)
    }

    if (e is Substraction) {
        return eval(e.right) - eval(e.left)
    }

    throw IllegalArgumentException("Unknown expression")
}

// if blocklarinda tek expression oldugu icin memeli parantezlere gerek yok
fun evalRefactor(e: Expression): Int =
    if (e is Number) e.value
    else if(e is Summary) eval(e.right) + eval(e.left)
    else throw IllegalArgumentException("unknown expression")

fun main() {
    println(eval(Number(4)))
    println(eval(Summary(Summary(Number(1), Number(2)), Number(4))))
    println(evalRefactor(Summary(Number(1), Number(2))))
}