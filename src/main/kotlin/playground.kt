fun main() {
    println(getSum(1, 4)) // 5
}

fun getSum(x: Int, y: Int): Int {
    val sum = { x: Int, y: Int ->
        println("Computing the sum of $x and $y...")
        x + y
    }

    return sum(x, y)
}

data class Person(val name: String, val age: Int)


