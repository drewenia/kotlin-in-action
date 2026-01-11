import kotlin.reflect.KProperty

class Email(val from: String, val to: String)

class Person(val name: String) {
    val emails by lazy {loadEmails(this)}
}

fun loadEmails(person: Person): List<Email> {
    println("Load emails for ${person.name}")
    return listOf(
        Email("test@abc.com", "alice@jb.com")
    )
}

class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }
}

class Example{
    var p : String by Delegate()
}

val lazyValue : String by lazy {
    println("computed")
    "Hello"
}

fun main() {
    println(lazyValue)
    // computed
    // Hello

    println(lazyValue)
    // Hello
}