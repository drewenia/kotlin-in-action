data class Email(val subject: String, val body: String)

data class Person(val name: String) {
    val emails by lazy { loadEmails(this) }
}

fun loadEmails(person: Person): List<Email> {
    println("Load emails for ${person.name}")
    return listOf(
        Email("Hey", "How are u?"),
        Email("Meeting", "At 18.00 a clock")
    )
}

fun main() {
    val p = Person("Alice")
    val emails = p.emails
    println(emails)
    // Load emails for Alice
    // [Email(subject=Hey, body=How are u?), Email(subject=Meeting, body=At 18.00 a clock)]
    println(emails)
    // [Email(subject=Hey, body=How are u?), Email(subject=Meeting, body=At 18.00 a clock)]
}