interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr
class Sub(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr) : Int =
    when(e){
        is Num -> {
            println("num : ${e.value}")
            e.value
        }
        is Sum -> {
            val left = eval(e.left)
            val right = eval(e.right)
            println("Left : $left, Right : $right")
            left + right
        }
        else -> throw IllegalArgumentException("wrong argument")
    }

fun main() {
    val result = eval(
        Sum(
            Sum(Num(1), Num(2)),
            Num(4)
        )
    )
    println(result)
    // num : 1
    // num : 2
    // Left : 1, Right : 2
    // num : 4
    // Left : 3, Right : 4
    // 7
}