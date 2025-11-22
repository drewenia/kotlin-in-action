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

interface Expression
class Number(val value: Int) : Expression
class Summary(val left: Expression, val right: Expression) : Expression
class Division(val left: Expression, val right: Expression) : Expression
class Multiply(val left: Expression, val right: Expression) : Expression
class Substraction(val left: Expression, val right: Expression) : Expression

fun evalWithLogging(e: Expression) : Int =
    when(e){
        is Num -> {
            println("num : ${e.value}")
            e.value
        }
        is Sum -> {
            val left = evalWithLogging(e.left)
            val right = evalWithLogging(e.right)
            println("sum : $left + $right")
            left + right
        }
        else -> throw IllegalArgumentException("unknown expression")
    }

fun main() {
    println(evalWithLogging(Sum(Sum(Num(1), Num(2)), Num(4))))
}