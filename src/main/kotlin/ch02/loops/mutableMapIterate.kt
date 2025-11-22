package ch02.loops

fun main() {
    val binaryRepresentation = mutableMapOf<Char,String>()
    for (char in 'A'..'F'){
        val binary = char.code.toString(radix = 2)
        binaryRepresentation[char] = binary
    }

    for ((letter,binary) in binaryRepresentation){
        println("$letter = $binary")
    }
}