fun main() {
    var email: String? = "yole@example.com"

    email?.let { sendEmailTo(it) }
    //Sending to : yole@example.com

    email = null
    email?.let { sendEmailTo(it) }
    // hiçbirşey yapmaz
}

fun sendEmailTo(email: String) = println("Sending to : $email")


// data class Person(val name: String, val age: Int)

