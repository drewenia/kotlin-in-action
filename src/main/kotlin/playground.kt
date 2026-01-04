fun main() {
    val words = listOf("Kotlin", "öğrenmek", "keyiflidir")

    val sentenceProgress = words.runningFold("Cümle") { acc, word ->
        "$acc $word"
    }
    println(sentenceProgress)
    // [Cümle, Cümle Kotlin, Cümle Kotlin öğrenmek, Cümle Kotlin öğrenmek keyiflidir]
}

data class Person(val name: String, val age: Int)

