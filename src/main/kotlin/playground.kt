

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr
class Sub(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int {
    if (e is Num) return e.value
    if (e is Sum) return eval(e.left) + eval(e.right)
    if (e is Sub) return eval(e.left) - eval(e.right)
    throw IllegalArgumentException("Unknown expression")
}

fun main() {
    // (1+2) + 4
    val result = eval(
        Sum(
            Sum(Num(1), Num(2)),
            Num(4)
        )
    )
    println(result) // 7
}