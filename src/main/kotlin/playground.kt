fun sendEmailTo(email: String) {
    println("Sending email to : $email")
}

fun main() {
    val recipient: String? = null

    // Safe call yok, bu yüzden **nullable type**’a sahiptir.
    // recipient.let { sendEmailTo(it) }
    // ERROR: Type mismatch:
    // inferred type is String? but String was expected
}


// data class Person(val name: String, val age: Int)

