package ch02.`when`

enum class Mnemonic()
{
    RED,
    ORANGE,
    YELLOW;

    fun mnemonic() = when(this){
        RED -> "Richard"
        ORANGE -> "Of"
        YELLOW -> "York"
    }
}

fun main() {
    val color = Mnemonic.RED.mnemonic()
    println(color)
}