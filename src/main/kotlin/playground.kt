fun main() {
    val sb = StringBuilder("Kotlin?")
    println(sb.lastChar) // ?
    sb.lastChar = '!'
    println(sb.lastChar) // !
}

var StringBuilder.lastChar: Char
    get() = this[length - 1]
    set(value) {
        this.setCharAt(length - 1, value)
    }
