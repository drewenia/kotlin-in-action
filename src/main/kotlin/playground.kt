fun main() {
    println("Minimum password length ${User.MIN_PASSWORD_LENGTH}") // Minimum password length 8

    val guest1 = User.createDefaultUser()
    println(guest1.nickname) // Guest 1

    val guest2 = User.createDefaultUser()
    println(guest2.nickname) // Guest 2
}

class User(val nickname : String){
    // class'ın companion (arkadaş) object'i
    companion object{
        const val MIN_PASSWORD_LENGTH = 8
        private var idCounter = 0

        fun createDefaultUser():User {
            idCounter++
            return User("Guest $idCounter")
        }
    }
}
