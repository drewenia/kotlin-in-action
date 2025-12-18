package ch03

/* Birçok developer, iyi code’un en önemli niteliklerinden birinin duplication olmaması olduğuna inanır. Bu ilkenin
özel bir adı bile vardır: don’t repeat yourself (DRY). Ancak Java’da yazarken bu ilkeyi takip etmek her zaman trivial
değildir. Çoğu durumda, IDE’nin Extract Method refactoring özelliğini kullanarak daha uzun method’ları daha küçük
parçalara ayırmak ve sonra bu parçaları yeniden kullanmak mümkündür. Fakat bu, code’u anlamayı zorlaştırabilir; çünkü
sonunda çok sayıda küçük method’a sahip ve aralarındaki ilişki net olmayan bir class ortaya çıkar. Daha da ileri gidip,
çıkarılan method’ları bir inner class içinde gruplayabilirsin; bu, yapıyı korumana olanak tanır, ancak bu yaklaşım ciddi
miktarda boilerplate gerektirir. Kotlin sana daha temiz bir çözüm sunar: extracted function’ları, onları içeren
function’ın içine nest edebilirsin. Bu sayede, ekstra bir syntactic overhead olmadan ihtiyaç duyduğun yapıya sahip
olursun. Local function’ları kullanarak oldukça yaygın bir code duplication durumunu nasıl düzeltebileceğimize bakalım.
Aşağıdaki code da, bir function bir user’ı database’e kaydeder ve user object’inin geçerli data içerdiğinden emin olman
gerekir. */

class User36(val id: Int, val name: String, val address: String)

fun saveUser36(user: User36) {
    if (user.name.isEmpty())
        throw IllegalArgumentException("can't save user ${user.id} : with empty name")
    if (user.address.isEmpty())
        throw IllegalArgumentException("can't save user ${user.id} : with empty address")

    // save user to the database
}

fun main() {
    saveUser36(User36(1, "", ""))
    // java.lang.IllegalArgumentException: can't save user 1 : with empty name
}

/* Buradaki duplicated code miktarı oldukça küçüktür ve muhtemelen class içinde, user validation'nın tek bir özel
case'ini handle eden tam teşekküllü bir method istemezsin. Ancak validation code’unu bir local function içine koyarsan,
duplication’dan kurtulabilir ve yine de net bir code structure’ı koruyabilirsin. İşte bunun nasıl çalıştığı. */

fun saveUser36v2(user: User36) {
    fun validate(
        user: User36,
        value: String,
        fieldName: String
    ) {
        if (value.isEmpty()) throw IllegalArgumentException(
            "Can't save user ${user.id}: empty $fieldName"
        )
    }
    validate(user, user.name, "Name")
    validate(user, user.address, "Address")

    // save user to the database
}

/* Bu hâliyle daha iyi görünüyor; validation logic’i duplicate edilmemiştir ve hâlâ validate function’ının scope’u
içinde tutulmaktadır. Proje geliştikçe, User’a başka field’lar eklemen gerektiğinde kolayca daha fazla validation
ekleyebilirsin. Ancak User object’ini validation function’ına geçirmek biraz çirkin duruyor. İyi haber şu ki, bu tamamen
gereksizdir; çünkü local function’lar, onları çevreleyen function’ın tüm parameter ve variable’larına erişebilir. Bundan
yararlanıp fazladan User parameter’ını ortadan kaldıralım. */

fun saveUser36v3(user: User36) {
    fun validate(
        value: String,
        fieldName: String
    ) {
        if (value.isEmpty())
            throw IllegalArgumentException(
                "Can't save user ${user.id}: empty $fieldName"
            )
    }
    validate(user.name, "User")
    validate(user.address, "Address")

    // save user to the database
}

/* Bu örneği daha da iyileştirmek için, validation logic’ini User class’ının bir extension function’ı içine
taşıyabilirsin. */

fun User36.validateBeforeSave36() {
    fun validate(
        value : String,
        fieldName : String
    ){
        if (value.isEmpty())
            throw IllegalArgumentException(
                "Can't save user $id: empty $fieldName"
            )
    }
    validate(name,"Name")
    validate(address, "Address")
}

fun saveUser36v4(user : User36){
    user.validateBeforeSave36()

    // Save user to the database
}

/* Bir code parçasını bir extension function’a çıkarmanın şaşırtıcı derecede faydalı olduğu ortaya çıkar. User senin
codebase’inin bir parçası olsa ve bir library class olmasa bile, bu logic’i User’ın bir method’u içine koymak
istemezsin; çünkü User’ın kullanıldığı diğer yerlerle ilgili değildir. Bu yaklaşımı izlersen, class’ın API’si her yerde
kullanılan yalnızca temel method’ları içerir; böylece class küçük kalır ve kavranması kolay olur. Öte yandan, öncelikli
olarak tek bir object ile ilgilenen ve onun private data’sına erişmesi gerekmeyen function’lar, yukarıda ki code’ta
olduğu gibi, ekstra qualification olmadan member’larına erişebilir. Extension function’lar local function olarak da
declare edilebilir; dolayısıyla User.validateBeforeSave’i saveUser içinde bir local function olarak tanımlayarak daha da
ileri gidebilirsin. Ancak derinlemesine nested local function’lar genellikle okunması oldukça zor olur; bu yüzden genel
bir kural olarak, birden fazla nesting seviyesinin kullanılmasını önermiyoruz. */