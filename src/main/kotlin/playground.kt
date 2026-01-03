fun main() {
    println(isAnswer)
}

fun interface Predicate<T> {
    fun accept(element: T): Boolean
}

val isAnswer = Predicate<Int> { i -> i == 42 }