open class Animal {
    fun feed() {
        println("Animal feeded")
    }
}

class Herd<out T : Animal>(private val animals: List<T>) {
    val size: Int get() = animals.size
    operator fun get(i: Int): T = animals[i]
}

fun feedAll(animals: Herd<Animal>) {
    for (i in 0..<animals.size) {
        animals[i].feed()
    }
}

class Cat : Animal() {
    fun cleanLitter() {
        println("Cat litter cleaned")
    }
}

fun takeCareOfCats(cats: Herd<Cat>) {
    for (i in 0..<cats.size) {
        cats[i].cleanLitter()
    }
    feedAll(cats)
}


fun main() {
    val catHerd = Herd(listOf(Cat(),Cat()))
    feedAll(catHerd)
}