fun main() {
    val db = Database()
    // Veri tabanından email gelmezse "Email bulunamadı" yazdırır.
    val email = db.getEmail() ?: "Email bulunamadı"
}

class Database {
    fun getEmail(): String? = null
}


// data class Person(val name: String, val age: Int)

