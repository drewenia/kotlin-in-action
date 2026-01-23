fun <T> copyData(source: MutableList<T>, destination: MutableList<in T>) {
    for (item in source) {
        destination.add(item)
    }
}

fun main() {
    val list : MutableList<out Number> = mutableListOf()
    // list.add(42)
    // Error: Out-projected type 'MutableList<out Number>',
    // 'fun add(element: E): Boolean' kullanımını yasaklar
}