fun main() {
    val list = listOf("apple", "apricot", "banana", "cantaloupe")

    val groupBy1 = list.groupBy(String::first) { it.uppercase() }
    println(groupBy1) // {a=[APPLE, APRICOT], b=[BANANA], c=[CANTALOUPE]}

    val groupBy2 = list.groupBy(String::first) { it.length }
    println(groupBy2) // {a=[5, 7], b=[6], c=[10]}

    val groupBy3 = list.groupBy(String::first) { it.drop(2) }
    println(groupBy3) // {a=[ple, ricot], b=[nana], c=[ntaloupe]}
}

data class Person(val name: String, val age: Int)

