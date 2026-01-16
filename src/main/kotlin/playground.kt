inline fun debugLog(block : () -> Unit){
    println("Log started")
    block()
    println("Log done!")
}
fun main() {
    println("Log started")
    println("Action started")
    println("Log done!")
}