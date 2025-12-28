fun main() {
    val list = listOf(
        Person("Alice", 30),
        Person("Bob", 25)
    )
    for((name,age) in list){
        println("Name : $name, Age : $age")
    }
    // Name : Alice, Age : 30
    // Name : Bob, Age : 25
}

data class Person(val name: String, val age: Int)