import java.net.URI

fun main() {
    val privateUser = PrivateUser("Ocean")
    println(privateUser.nickname) // Ocean

    val subscribingUser = SubscribingUser("egedata@gmail.com")
    println(subscribingUser.nickname) // egedata

    val socialUser = SocialUser(14)
    println(socialUser.nickname) // kodee14

}

interface User {
    val nickname: String
}

class PrivateUser(override val nickname: String) : User

class SubscribingUser(val email: String) : User {
    override val nickname: String
        get() = email.substringBefore('@')
}

class SocialUser(accountId: Int) : User{
    override val nickname: String = getNameFromSocialNetwork(accountId)
}

fun getNameFromSocialNetwork(accountId : Int) =
    "kodee$accountId"

interface EmailUser {
    val email : String

    // Property’nin bir backing field’ı yoktur: result value her erişimde hesaplanır.
    val nickname : String
        get() = email.substringBefore('@')
}