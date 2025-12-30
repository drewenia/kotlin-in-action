fun main() {
    val countingSet = CountingSet<Int>()
    countingSet.addAll(listOf(1, 2, 4, 4, 2))
    println("Added ${countingSet.objectsAdded} objects, ${countingSet.size} uniques")
    // Added 5 objects, 3 uniques
}

class CountingSet<T>(
    private val innerSet: MutableCollection<T> = hashSetOf()
) : MutableCollection<T> by innerSet {
    var objectsAdded: Int = 0

    override fun add(element: T): Boolean {
        objectsAdded++
        return innerSet.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        objectsAdded += elements.size
        return innerSet.addAll(elements)
    }
}