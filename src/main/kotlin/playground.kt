import java.net.URI

fun main() {
    val lc = LengthCounter()
    lc.addWord("Hello, World!")
    println(lc.counter) // 13

    // Error üretir çünkü set private halde
    // lc.counter = 0
}

class LengthCounter {
    var counter: Int = 0
        // Bu property’yi class dışında değiştiremezsiniz.
        private set

    fun addWord(word: String) {
        counter += word.length
    }
}

