import java.net.URI

fun main() {

}

class PersonTrivial(val name: String, val age: Int)

class PersonNonTrivial(val name: String, val birthYear: Int) {
    val age : Int = 2025 - birthYear
}

// name için Otomatik getter/setter üretir
class Person(var name : String)