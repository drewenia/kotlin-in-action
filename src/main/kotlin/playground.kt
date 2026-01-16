data class Person(
    val firstName: String,
    val lastName: String,
    val phoneNumber: String?
)

class ContactListFilters {
    var prefix: String = ""
    var onlyWithPhoneNumber: Boolean = false

    fun getPredicate(): (Person) -> Boolean {
        // Bir function döndüren bir function declare eder
        val startsWithPrefix = { p: Person ->
            p.firstName.startsWith(prefix) ||
                    p.lastName.startsWith(prefix)
        }
        if (!onlyWithPhoneNumber) {
            // Bir function type türünde bir variable döndürür
            return startsWithPrefix
        }
        // Bu function’dan bir lambda döndürür
        return { startsWithPrefix(it) && it.phoneNumber != null }
    }
}

fun main() {
    val contacts = listOf(
        Person("Dimitry", "Jemerov", "123-4567"),
        Person("Swetlana", "Isakova", null)
    )

    val contactListFilters = ContactListFilters()
    with(contactListFilters) {
        prefix = "D"
        onlyWithPhoneNumber = true
    }

    // contacts.filter(contactListFilters.getPredicate())
    // getPredicate tarafından döndürülen function’ı filter’a argument olarak geçirir
    val filtered = contacts.filter(contactListFilters.getPredicate())
    println(filtered) // [Person(firstName=Dimitry, lastName=Jemerov, phoneNumber=123-4567)]

    val contactListFilters2 = ContactListFilters();
    with(contactListFilters2){
        onlyWithPhoneNumber = false
    }

    val filtered2 = contacts.filter(contactListFilters2.getPredicate())
    println(filtered2)
    // [Person(firstName=Dimitry, lastName=Jemerov, phoneNumber=123-4567),
    // Person(firstName=Swetlana, lastName=Isakova, phoneNumber=null)]
}