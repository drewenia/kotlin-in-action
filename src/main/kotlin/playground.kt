data class Person(val name: String, val age: Int)

val people = listOf(
    Person("Alice", 29),
    Person("Bob", 31)
)

fun lookForAlice(people: List<Person>) {
    // Lambda expression’ı label’lar
    people.forEach {
        // return@label, bu label’a referans verir.
        if (it.name != "Alice") return@forEach
        // Bu satır yalnızca return execute edilmediğinde yazdırılır.
        println("Found Alice")
    }
}

fun main() {
    // Bu lambda’nın implicit receiver’ına this@sb ile erişilir.
    println(StringBuilder().apply sb@{
        listOf(1, 2, 3).apply { // this, scope’daki en yakın implicit receiver’a referans verir.
            // Tüm implicit receiver’lara erişilebilir; dıştaki olanlara explicit label’lar aracılığıyla.
            this@sb.append(this.toString())
        }
    })
    // [1, 2, 3]
}