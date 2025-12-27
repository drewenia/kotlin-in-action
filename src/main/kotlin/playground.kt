interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr
class Sub(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int =
    when(e) {
        is Num -> e.value
        is Sum -> eval(e.left) + eval(e.right)
        else -> throw IllegalArgumentException("Unknown expression")
    }

fun main() {
    val result = eval(
        Sum(
            Sum(Num(1), Num(2)),
            Num(4)
        )
    )
    println(result) // 7
}