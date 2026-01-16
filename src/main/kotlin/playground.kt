inline fun createTransformer(
    multiplier: Int,
    noinline transformLogic: (Int) -> Int // // Döndürülebilmesi için noinline olmalıdır
): (Int) -> Int {
    println("Creating a transformer for multiplier: $multiplier")
    return transformLogic
}

fun main() {
    val myDoubleTransformer = createTransformer(2) { it * 2 }
    println(myDoubleTransformer(20))
}