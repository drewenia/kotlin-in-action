fun main() {
    val text = "12.345-6.A"
    val splittedText = text.split(".","-")
    println(splittedText) // [12, 345, 6, A]
}