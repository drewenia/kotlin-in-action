interface Processor<T> {
    fun process() : T
}

class NoResultProcessor : Processor<Unit>{
    // Unit döner, ancak type specification’ı atlıyorsun.
    override fun process(){
        val tax = 100 * 0.18
        println("Tax : $tax")
    } // Burada explicit bir return’a gerek yok.
}

fun main() {
    val nrs = NoResultProcessor()
    println(nrs.process())
    // Tax : 18.0
    // kotlin.Unit
}

