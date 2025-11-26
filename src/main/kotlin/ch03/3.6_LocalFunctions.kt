package ch03

class User(val id: Int, val name: String, val address: String)

fun saveUser(user: User) {
    if (user.name.isEmpty()) {
        throw IllegalArgumentException(
            "Cant save user ${user.id}: empty Name"
        )
    }

    if (user.address.isEmpty()) {
        throw IllegalArgumentException(
            "Cant save user ${user.id}: empty address"
        )
    }

    // Save user to the database
}

fun main() {
    saveUser(User(1, "", ""))
}

/* Buradaki duplicated code miktarı oldukça küçüktür ve muhtemelen class’ınızda user’ı validate etmenin tek bir özel
durumunu ele alan tam bir method bulundurmak istemezsiniz. Ancak validation code’u bir local function içine koyarsanız,
duplication’dan kurtulabilir ve yine de net bir code yapısını koruyabilirsiniz. İşte nasıl çalıştığı:
*/

fun saveUserLocalFunction(user: User) {
    fun validate(
        user: User,
        value: String,
        fieldName: String
    ) {
        if (value.isEmpty()) {
            throw IllegalArgumentException(
                "Cant save user ${user.id}: empty $fieldName"
            )
        }
    }
    validate(user, user.name, "Name")
    validate(user, user.address, "Address")

    // Save user to the database
}

/* Yukarıda ki code daha iyi görünmektedir; validation logic duplicated değil, ancak hâlâ validate function’ın scope’u
ile sınırlıdır. Proje geliştikçe, User’a başka field’lar eklemeniz gerekirse kolayca daha fazla validation
ekleyebilirsiniz. Ancak User object’i validation function’a geçirmek biraz çirkindir. İyi haber, bunun tamamen gereksiz
olmasıdır çünkü local function’lar, enclosing function’ın tüm parameter ve variable’larına erişebilir. Bunu avantaja
çevirelim ve ekstra User parameter’ından kurtulalım.*/

fun saveUserLocalFunctionRefactor(user : User){
    fun validate (value : String, fieldName : String){
        if (value.isEmpty()){
            throw IllegalArgumentException(
                "Cant save user ${user.id} : empty : $fieldName"
            )
        }
    }

    validate(user.name,"Name")
    validate(user.address,"Address")

    // Save user to the database
}

/* Bu örneği daha da geliştirmek için fonksiyonu User class'ın extension function'i haline getirelim */

fun User.validateBeforeSave() {
    fun validate(value : String, fieldName : String){
        if (value.isEmpty()){
            throw IllegalArgumentException(
                "Cant save user $id: empty $fieldName"
            )
        }
    }
    validate(name, "Name")
    validate(address, "Address")
}

fun saveUserRefactor(user : User){
    user.validateBeforeSave() // Calls the extension function

    // save user to the database
}


