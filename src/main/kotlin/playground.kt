fun main() {
    printListWithIndex()
}

fun printListWithIndex() {
    val list = listOf("10", "11", "1001")
    for((index, element) in list.withIndex()){
        println("Index : $index, Element : $element")
        // Index : 0, Element : 10
        // Index : 1, Element : 11
        // Index : 2, Element : 1001
    }
}