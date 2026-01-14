import kotlin.properties.Delegates

var max: Int by Delegates.vetoable(0) { property, oldValue, newValue ->
    newValue > oldValue
}

fun main() {
    println(max) // 0
    max = 5
    println(max) // 5
    max = 10
    println(max) // 10
    max = 9
    println(max) // 10
}

