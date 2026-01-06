fun main() {
    val list = listOf(
        listOf("Apple", "Banana"),
        listOf("Milk", "Cheese", "Yoghurt"),
        listOf("Bread")
    )

    println(list) // [[Apple, Banana], [Milk, Cheese, Yoghurt], [Bread]]

    val flatten = list.flatten()
    println(flatten) // [Apple, Banana, Milk, Cheese, Yoghurt, Bread]
}

class Book(val title: String, val authors: List<String>)

data class Person(val name: String, val age: Int)

