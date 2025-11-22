package ch02.loops

fun main() {
    val list = listOf("10", "11", "21", "1001")
    for ((index,element) in list.withIndex()){
        println("Index : $index element : $element")
    }
}