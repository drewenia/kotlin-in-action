fun main() {

}

fun processTheAnswer(f: Function1<Int, Int>) {
    println(f.invoke(42))
}

// Function2<Int, Int, Int> ile eşdeğer
class Adder : (Int, Int) -> Int{
    override fun invoke(
        p1: Int,
        p2: Int
    ): Int {
        return p1 + p2
    }
}